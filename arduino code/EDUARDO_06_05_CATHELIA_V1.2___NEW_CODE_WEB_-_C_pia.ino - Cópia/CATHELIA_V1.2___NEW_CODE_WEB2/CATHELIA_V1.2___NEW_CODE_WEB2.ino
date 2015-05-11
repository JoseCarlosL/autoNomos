
/*-------------------------------------------------------------------------------------------------------------------------------------------------------------//
|
|                                                        CÓDIGO DESENVOLVIDO PELA AUTONOMOS AUTOMAÇÃO RESIDENCIA.
|                                                                            PROJETO:CATHELIA
|                                                                                 V:1.2.0
|
*///--------------------------------------------------------------------------------------------------------------------------------------------------------------//


#include <SPI.h>
#include <Ethernet.h>
#include <Twitter.h>
#include <DS1307.h>

//LISTA DE VARIÁREIS ULTILIZADAS NO SISTEMA

//RELÓGIO
//Modulo RTC DS1307 ligado as portas A4 e A5 do Arduino 
DS1307 rtc(A4, A5);

//  ILUMINAÇÃO.
const int iluminacao_jardim = 3;
const int iluminacao_piscina = 4;
const int iluminacao_principal_sala = 5;
const int iluminacao_baixa_sala = 6;
const int iluminacao_quarto_filho_um = 7;
const int iluminacao_quarto_filho_dois = 8;
const int iluminacao_quarto_casal = 9;

//  CONSUMO LUZ.
const int sensorPin = A0;
float sensorValue_aux = 0;
float sensorValue = 0;
float currentValue = 0;
float voltsporUnidade = 0.0048828125;

float watts;
float kwatt;

float media = 0;
float mediakwatts;
float vpagar;      
int i = 0;

// RESERVATÓRIO_ÁGUA.
float vazao; //Variável para armazenar o valor em L/min
float mediai=0; //Variável para tirar a média a cada 1 minuto
int contaPulso; //Variável para a quantidade de pulsos
int j = 0; //Variável para contagem

// SENSOR DE TEMPERATURA.
int pinoSensor = 0;
int valorLido = 0;
float temperatura = 0;

// INICIO LISTA DE MÉTODOS A SEREM CHAMADOS.

void temperatura_atual(){
  valorLido = analogRead(pinoSensor);
  temperatura = (valorLido * 0.00488);
  temperatura = temperatura * 100;
  Serial.print("Temperatura actual: ");
  Serial.println(temperatura);
  delay(1000);
}

//MÉTODO DE AUXILIO DE LEITURA DO CÓDIOGO DE FLUXO
void incpulso ()
{ 
  contaPulso++; //Incrementa a variável de contagem dos pulsos
} 

//CONFIGURAÇÃO DA REDE
  byte mac[] = { 0xDE, 0xAD, 0xBE, 0xEF, 0xFE, 0xED };   //physical mac address
  byte ip[] = {192 ,168 ,1 ,11 };                      // ip in lan (that's what you need to use in your browser. ("192.168.1.178")
  byte gateway[] = { 192, 168, 1, 1};                   // internet access via router
  byte subnet[] = { 255, 255, 255, 0 };                  //subnet mask
  EthernetServer server(80);  //server port     

  String readString;

  Twitter twitter("3091853805-vOzAabvqFttrAakcTnaxL5FY25mH2WvBPiDo8pK");

  //POSTS DO TWITTER 
  char iluminacao_jardim_on_twitter[] = "eco_HOME, testando nova IDE, SUBLIME.";
  char iluminacao_jardim_off_twitter[] = "eco_HOME, teste .";

  char iluminacao_piscina_on_twitter[] = "eco_HOME, teste iluminação da piscina ligada.";
  char iluminacao_piscina_off_twitter[] = "eco_HOME, teste iluminação da piscina desligada.";

  char iluminacao_principal_sala_on_twitter[] = "eco_HOME, teste iluminação da sala ligada.";
  char iluminacao_principal_sala_off_twitter[] = "eco_HOME, teste iluminação da sala desligada.";

  char iluminacao_baixa_sala_on_twitter[] = "eco_HOME, teste iluminação baixa da sala ligada.";
  char iluminacao_baixa_sala_off_twitter[] = "eco_HOME, teste iluminação baixa da sala desligada.";

  char iluminacao_quarto_filho_um_on_twitter[] = "eco_HOME, teste iluminação do quarto do filho UM está ligada.";
  char iluminacao_quarto_filho_um_off_twitter[] = "eco_HOME, teste iluminação do quarto do filho UM está desligada.";

  char iluminacao_quarto_filho_dois_on_twitter[] = "eco_HOME, teste iluminação do quarto do filho DOIS está ligada.";
  char iluminacao_quarto_filho_dois_off_twitter[] = "eco_HOME, teste iluminação do quarto do filho DOIS está desligada.";

  char iluminacao_quarto_casal_on_twitter[] = "eco_HOME, teste iluminação do quarto do casal está ligada.";
  char iluminacao_quarto_casal_off_twitter[] = "eco_HOME, teste iluminação do quarto do casal está desligada.";

  void setup() {
    // or you can use DHCP for autoomatic IP address configuration.
    Ethernet.begin(mac);
    // Open serial communications and wait for port to open:
    Serial.begin(9600);
    while (!Serial) {
      ; // wait for serial port to connect. Needed for Leonardo only
    }
    //INÍCIO DO SETUP DO RELÓGIO
    //Aciona o relogio
  rtc.halt(false);
   
  //As linhas abaixo setam a data e hora do modulo
  //e podem ser comentada apos a primeira utilizacao
  rtc.setDOW(FRIDAY);      //Define o dia da semana
  rtc.setTime(20, 37, 0);     //Define o horario
  rtc.setDate(6, 6, 2014);   //Define o dia, mes e ano
   
  //Definicoes do pino SQW/Out
  rtc.setSQWRate(SQW_RATE_1);
  rtc.enableSQW(true);
    //FIM DO SETUP DO RELÓGIO
    
    //DEFINIÇÃO DOS PINOS E SUAS SAIDAS.
    pinMode(iluminacao_jardim, OUTPUT);
    pinMode(iluminacao_piscina, OUTPUT);
    pinMode(iluminacao_principal_sala, OUTPUT);
    pinMode(iluminacao_baixa_sala, OUTPUT);
    pinMode(iluminacao_quarto_filho_um, OUTPUT);
    pinMode(iluminacao_quarto_filho_dois, OUTPUT);
    pinMode(iluminacao_quarto_casal, OUTPUT);

    //DEFINIÇÃO DO SETUP DE CONTROLE DO SENSOR DE FLUXO.
      pinMode(2, INPUT);
      attachInterrupt(0, incpulso, RISING); //Configura o pino 2(Interrupção 0) para trabalhar como interrupção
      Serial.println("\n\nInicio\n\n"); //Imprime Inicio na serial

    // ESSE BLOCO DE CÓDIGO ORIENTA A LÓGICA A INICIAR TODAS VARIAVEIS, COM 0 NO ESTADO LÓGICO.
    digitalWrite(iluminacao_jardim, HIGH);
    digitalWrite(iluminacao_piscina, HIGH);
    digitalWrite(iluminacao_jardim, HIGH);
    digitalWrite(iluminacao_piscina, HIGH);
    digitalWrite(iluminacao_principal_sala, HIGH);
    digitalWrite(iluminacao_baixa_sala, HIGH);
    digitalWrite(iluminacao_quarto_filho_um, HIGH);
    digitalWrite(iluminacao_quarto_filho_dois, HIGH);
    digitalWrite(iluminacao_quarto_casal, HIGH);


    // start the Ethernet connection and the server:
    Ethernet.begin(mac, ip, gateway, subnet);
    server.begin();
    Serial.print("server is at ");
    Serial.println(Ethernet.localIP());
  }


  void loop() {
    // Create a client connection
    EthernetClient client = server.available();
    if (client) {
      while (client.connected()) {   
        if (client.available()) {
          char c = client.read();

          //read char by char HTTP request
          if (readString.length() < 100) {
            //store characters to string
            readString += c;
            //Serial.print(c);
          }

          //if HTTP request has ended
          if (c == '\n') {          
           Serial.println(readString); //print to serial monitor for debuging
           
          client.println("HTTP/1.1 200 OK"); //send new page
          client.println("Content-Type: text/html");
          client.println(); 
          client.println("<html>");
          client.println("<head>");
          client.println("<title>Iluminação</title>");
          client.println("<meta charset='UTF-8' />");
          client.println("<link href='http://localhost/autonomos/css/iluminacao.css' type='text/css' rel='stylesheet' />");
          client.println("<script src='http://localhost/autonomos/js/iluminacao.js' type='text/javascript'></script>");
          client.println("</head>");
          client.println("<body>");
          client.println("<div id='comodos'>");
          client.println("<fieldset>");
          client.println("<legend>JARDIM</legend>");
          client.println("<ul>");          
          client.println("<div id='sala'>");
          client.println("<li>Iluminação Jardim <br>");
          client.println("<a href=\"/?iluminacao_jardim_on\"\">");
          client.println("<input class='button' type='button' value='Ligar'/>");
          client.println("<a href=\"/?iluminacao_jardim_off\"\">");
          client.println("<input class='button2' type='button' value='Desligar'/>"); 
          //if(status_iluminacao_jardim == 1){
            if (readString.indexOf("?iluminacao_jardim_on") >0){
            client.println("<img src='http://localhost/autonomos/img/on.png'/>");
          }
          //else if (status_iluminacao_jardim == 0){
            else{
                client.println("<img src='http://localhost/autonomos/img/off.png'/>");
          }
          client.println("</li>");
          client.println("</div>"); 
          client.println("</ul>");
          client.println("</fieldset>");      
          client.println("<fieldset>");
          client.println("<legend>Sala</legend>");
          client.println("<ul>");
          client.println("<div id='quarto'>");
          client.println("<li>Luz alta <br>");
          client.println("<a href=\"/?iluminacao_sala_alta_on\"\">");
          client.println("<input class='button' type='button' value='Ligar' onclick='ligarSala1();'/>");
          client.println("<a href=\"/?iluminacao_sala_alta_off\"\">");
          client.println("<input class='button2' type='button' value='Desligar' onclick='desligarSala1();'/>");
          client.println("<img id='statusq1' src='http://localhost/autonomos/img/erro.png' />");
          client.println("</li>");
          client.println("<li>Luz baixa <br>");
          client.println("<input class='button' type='button' value='Ligar' onclick='ligarQuarto2();'/>");
          client.println("<input class='button2' type='button' value='Desligar' onclick='desligarQuarto2();'/>");
          client.println("<img id='statusq2' src='http://localhost/autonomos/img/erro.png' />");
          client.println("</li>");
          client.println("<li>Lustre <br>");
          client.println("<input class='button' type='button' value='Ligar' onclick='ligarQuarto3();'/>");
          client.println("<input class='button2' type='button' value='Desligar' onclick='desligarQuarto3();'/>");
          client.println("<img id='statusq3' src='http://localhost/autonomos/img/erro.png' />");
          client.println("</li>");
          client.println("</div>");
          client.println("</ul>");
          client.println("</fieldset>");
          client.println("<fieldset >");
          client.println("<legend>BANHEIRO</legend>");
          client.println("<ul>");
          client.println("<div id='banheiro'>");
          client.println("<li>Luz alta <br>");
          client.println("<input class='button' type='button' value='Ligar' onclick='ligarBanheiro1();'/>");
          client.println("<input class='button2' type='button' value='Desligar' onclick='desligarBanheiro1();'/>");
          client.println("<img id='statusb1' src='http://localhost/autonomos/img/erro.png' />");
          client.println("</li>");
          client.println("<li>Luz baixa <br>");
          client.println("<input class='button' type='button' value='Ligar' onclick='ligarBanheiro2();'/>");
          client.println("<input class='button2' type='button' value='Desligar' onclick='desligarBanheiro2();'/>");
          client.println("<img id='statusb2' src='http://localhost/autonomos/img/erro.png' />");
          client.println("</li>");
          client.println("<li>Lustre <br>");
          client.println("<input class='button' type='button' value='Ligar' onclick='ligarBanheiro3();'/>");
          client.println("<input class='button2' type='button' value='Desligar' onclick='desligarBanheiro3();'/>");
          client.println("<img id='statusb3' src='http://localhost/autonomos/img/erro.png' />");
          client.println("</li>");
          client.println("</div>");
          client.println("</ul>");
          client.println("</fieldset>");
          client.println("</div>");
          client.println("</body>");
          client.println("</html>");
           
           delay(1);
           //stopping client
           client.stop();

           //SET DE BOTOES DE ACIONAMENTO DA ILUMINAÇÃO DO JARDIM NO ARDUINO           
           if (readString.indexOf("?iluminacao_jardim_on") >0){
            digitalWrite(iluminacao_jardim, !HIGH);
            delay(1000);
            Ethernet.begin(mac, ip);
            Serial.println("connecting ...");
            if (twitter.post(iluminacao_jardim_on_twitter)) {
              int status = twitter.wait();    
              if (status == 200) {
                Serial.println("OK.");
              } 
              else {
                Serial.print("failed : code ");
                Serial.println(status);
              }
            } 
            else {
              Serial.println("connection failed.");
            }
          }

          else if (readString.indexOf("?iluminacao_piscina_on") >0){
           digitalWrite(iluminacao_jardim, !LOW);

           delay(1000);
           Ethernet.begin(mac, ip);
           Serial.println("connecting ...");
           digitalWrite(iluminacao_jardim, !LOW);
           if (twitter.post(iluminacao_jardim_off_twitter)) {
             int status = twitter.wait();    
             if (status == 200) {
              Serial.println("OK.");
            } 
            else {
              Serial.print("failed : code ");
              Serial.println(status);
            }  
          } 
          else {
            Serial.println("connection failed.");
          }
        }


        //SET DE BOTOES DE ACIONAMENTO DA ILUMINAÇÃO DA PISCINA NO ARDUINO
        else if (readString.indexOf("?iluminacao_piscina_on") >0){
         digitalWrite(iluminacao_piscina, !HIGH); 
         delay(1000);
         Ethernet.begin(mac, ip);
         Serial.println("connecting ...");
         if (twitter.post(iluminacao_piscina_on_twitter)) {
          int status = twitter.wait();    
          if (status == 200) {
            Serial.println("OK.");
          } 
          else {
            Serial.print("failed : code ");
            Serial.println(status);
          }
        } 
        else {
          Serial.println("connection failed.");
        }
      }     

      else if (readString.indexOf("?iluminacao_piscina_off") >0){
       digitalWrite(iluminacao_piscina, !LOW); 
       delay(1000);
       Ethernet.begin(mac, ip);
       Serial.println("connecting ...");
       if (twitter.post(iluminacao_piscina_off_twitter)) {
        int status = twitter.wait();    
        if (status == 200) {
          Serial.println("OK.");
        } 
        else {
          Serial.print("failed : code ");
          Serial.println(status);
        }
      } 
      else {
        Serial.println("connection failed.");
      } 
    }

    //SET DE BOTOES DE ACIONAMENTO DA ILUMINAÇÃO PRINCIPAL DA SALA NO ARDUINO.
    else if (readString.indexOf("?iluminacao_principal_sala_on") >0){
     digitalWrite(iluminacao_principal_sala, !HIGH); 
     delay(1000);
     Ethernet.begin(mac, ip);
     Serial.println("connecting ...");
     if (twitter.post(iluminacao_principal_sala_on_twitter)) {
      int status = twitter.wait();    
      if (status == 200) {
        Serial.println("OK.");
      } 
      else {
        Serial.print("failed : code ");
        Serial.println(status);
      }
    } 
    else {
      Serial.println("connection failed.");
    }
  }    

  else if (readString.indexOf("?iluminacao_principal_sala_off") >0){
   digitalWrite(iluminacao_principal_sala, !LOW); 
   delay(1000);
   Ethernet.begin(mac, ip);
   Serial.println("connecting ...");
   if (twitter.post(iluminacao_principal_sala_off_twitter)) {
    int status = twitter.wait();    
    if (status == 200) {
      Serial.println("OK.");
    } 
    else {
      Serial.print("failed : code ");
      Serial.println(status);
    }
  } 
  else {
    Serial.println("connection failed.");
  } 
}

//SET DE BOTOES DE ACIONAMENTO DA ILUMINAÇÃO BAIXA DA SALA NO ARDUINO. 
else if (readString.indexOf("?iluminacao_baixa_sala_on") >0){
 digitalWrite(iluminacao_baixa_sala, !HIGH); 
 delay(1000);
 Ethernet.begin(mac, ip);
 Serial.println("connecting ...");
 if (twitter.post(iluminacao_baixa_sala_on_twitter)) {
  int status = twitter.wait();    
  if (status == 200) {
    Serial.println("OK.");
  } 
  else {
    Serial.print("failed : code ");
    Serial.println(status);
  }
} 
else {
  Serial.println("connection failed.");
}
}  
              
else if (readString.indexOf("?luminacao_baixa_sala_off") >0){
 digitalWrite(iluminacao_principal_sala, !LOW); 
 delay(1000);
 Ethernet.begin(mac, ip);
 Serial.println("connecting ...");
 if (twitter.post(iluminacao_principal_sala_off_twitter)) {
  int status = twitter.wait();    
  if (status == 200) {
    Serial.println("OK.");
  } 
  else {
    Serial.print("failed : code ");
    Serial.println(status);
  }
} 
else {
  Serial.println("connection failed.");
} 
}

//ESSE BLOCO DEVE SER IMPLEMENTADO DENTRO DO BOTÃO QUE CHAMA O MÉTODO PRA VIZUALIZAR O CONSUMO DE ENERGIA.
for(int i=500; i>0; i--){
 sensorValue_aux = (analogRead(sensorPin) -511); // le o sensor na pino analogico A0 e ajusta o valor lido ja que a saída do sensor é vcc/2 para corrente =0
 sensorValue += pow(sensorValue_aux,2); // soam os quadardos das leituras no laco
 }
 
sensorValue = (sqrt(sensorValue/ 500)) * voltsporUnidade; // finaliza o calculo da méida quadratica e ajusta o valor lido para volts
 currentValue = (sensorValue/66)*1000; // calcula a corrente considerando a sensibilidade do sernsor (66 mV por amper)

watts=currentValue*220; // converte o valor de corrente para watts.
kwatt=watts/1000;//converte o valor de watts para kwatts

media = media+kwatt; //Soma a corrente para o calculo da media.
i++;

 // mostra o resultado no terminal
 Serial.print("kWatts " );
 Serial.print(kwatt);
 Serial.print("\n" );
 sensorValue =0;
 delay(1000);
 


if(i==60){

    media = media/60; //Tira a media dividindo por 60
    Serial.print("\Media por Minuto = "); //Imprime a frase Media por minuto =
    Serial.print(media); //Imprime o valor da media
     
     //media=mediakwatts;
     //mediakwatts=mediakwatts*60;
     vpagar = media*0.50; 
      
    Serial.print("\nMedia por Hora = "); //Imprime a frase Media por minuto =
    Serial.println(media*60); 
    
    Serial.println("\nO valor da conta e de ="); 
    Serial.print(vpagar); 
    Serial.println("\n");
    media = 0; //Zera a variável media para uma nova contagem
    i=0; //Zera a variável i para uma nova contagem    
}

//FINALIZA O BLOCO DE LEITURA DA ENERGIA.

//ESSE BLOCO COMO O BLOCO DE CÓDIGO DO SENSOR DE CORRENTE DEVE SER IMPLEMENTADO NO BOTÃO DE CHAMADA DO MÉTODO DE LEITURA DO FLUXO DE AGUA
  contaPulso = 0;   //Zera a variável para contar os giros por segundos
  sei();      //Habilita interrupção
  delay (1000); //Aguarda 1 segundo
  cli();      //Desabilita interrupção
  
  vazao = contaPulso / 5.5; //Converte para L/min
  mediai=mediai+vazao; //Soma a vazão para o calculo da media
  j++;
  
  Serial.print(vazao); //Imprime na serial o valor da vazão
  Serial.print(" L/min - "); //Imprime L/min
  Serial.print(i); //Imprime a contagem i (segundos)
  Serial.println("s"); //Imprime s indicando que está em segundos
  
  if(j==60)
  {
    mediai = mediai/60; //Tira a media dividindo por 60
    Serial.print("\nMedia por minuto = "); //Imprime a frase Media por minuto =
    Serial.print(mediai); //Imprime o valor da media
    Serial.println(" L/min - "); //Imprime L/min
    media = 0; //Zera a variável media para uma nova contagem
    j=0; //Zera a variável i para uma nova contagem
    Serial.println("\n\nInicio\n\n"); //Imprime Inicio indicando que a contagem iniciou
  }
  //FINALIZA O BLOCO DE LEITURA DO FLUXO.
  
  //INÍCIO DO METODO DE LEITURA DO RELÓGIO.
  //Mostra as informações no Serial Monitor
  Serial.print("Hora : ");
  Serial.print(rtc.getTimeStr());
  Serial.print(" ");
  Serial.print("Data : ");
  Serial.print(rtc.getDateStr(FORMAT_SHORT));
  Serial.print(" ");
  Serial.println(rtc.getDOWStr(FORMAT_SHORT));
  //FIM DO MÉTODO DE LEITURA DO RELÓGIO.

//clearing string for next read
readString="";  
}
}
}
}
}
