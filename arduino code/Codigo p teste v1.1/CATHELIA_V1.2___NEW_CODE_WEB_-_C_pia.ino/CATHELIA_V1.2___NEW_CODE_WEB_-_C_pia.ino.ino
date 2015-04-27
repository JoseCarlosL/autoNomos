
/*-------------------------------------------------------------------------------------------------------------------------//
|
|                           CÓDIGO DESENVOLVIDO PELA AUTONOMOS AUTOMAÇÃO RESIDENCIA.
|                                               PROJETO:CATHELIA
|                                                    V:1.2.0
|
*///-------------------------------------------------------------------------------------------------------------------------//

#include <SPI.h>
#include <Ethernet.h>
#include <Twitter.h>

//LISTA DE VARIÁREIS ULTILIZADAS NO SISTEMA
//  ILUMINAÇÃO.
const int iluminacao_jardim = 13;
const int iluminacao_sala_alta = 2;
const int iluminacao_sala_baixa = 3;
const int iluminacao_quarto_filho1 = 4;
const int iluminacao_quarto_filho2 = 5;
const int iluminacao_quarto_casal = 6;

//BLOCO DE VARIÁVEIS DE STATUS.
  int status_iluminacao_jardim = LOW;
  int status_iluminacao_sala_alta;
  int status_iluminacao_sala_baixa;  
  int status_iluminacao_quarto_filho1;
  int status_iluminacao_quarto_filho2;
  int status_luminacao_quarto_casal;

//CONFIGURAÇÃO DA REDE
  byte mac[] = { 0xDE, 0xAD, 0xBE, 0xEF, 0xFE, 0xED };   //physical mac address
  byte ip[] = {192 ,168 ,1 , 251};                      // ip in lan (that's what you need to use in your browser. ("192.168.1.178")
  byte gateway[] = { 192 ,168 ,1 ,254};                   // internet access via router
  byte subnet[] = { 255, 255, 255, 0 };                  //subnet mask
  EthernetServer server(80);  //server port     

  String readString;

  //LOGIN NA CONTA DA ECOHOME NO TWITTER.
  Twitter twitter("3091853805-vOzAabvqFttrAakcTnaxL5FY25mH2WvBPiDo8pK");


  //POSTS DO TWITTER 
  char tweet[] = "teste novo código";

  void setup() {
        
    int incomingByte = 0;
    // or you can use DHCP for autoomatic IP address configuration.
    Ethernet.begin(mac);
    // Open serial communications and wait for port to open:
    Serial.begin(9600);
    while (!Serial) {
      ; // wait for serial port to connect. Needed for Leonardo only
    }

    //DEFINIÇÃO DOS PINOS E SUAS SAIDAS.
    pinMode(iluminacao_jardim, OUTPUT);
    pinMode(iluminacao_sala_alta, OUTPUT);
    pinMode(iluminacao_sala_baixa, OUTPUT);
    pinMode(iluminacao_quarto_filho1, OUTPUT); 
    pinMode(iluminacao_quarto_filho2, OUTPUT);
    pinMode(iluminacao_quarto_casal, OUTPUT); 

    // ESSE BLOCO DE CÓDIGO ORIENTA A LÓGICA A INICIAR TODAS VARIAVEIS, COM 0 NO ESTADO LÓGICO.
/*  digitalWrite(iluminacao_jardim, LOW);
    digitalWrite(iluminacao_sala_alta, LOW);
    digitalWrite(iluminacao_sala_baixa, LOW);
    digitalWrite(iluminacao_quarto_filho1,LOW);
    digitalWrite(iluminacao_quarto_filho2, LOW);
    digitalWrite(iluminacao_quarto_casal, LOW);
*/
    // start the Ethernet connection and the server:
    Ethernet.begin(mac, ip, gateway, subnet);
    server.begin();
    Serial.print("server is at ");
    Serial.println(Ethernet.localIP());
  }
 

  void loop() {
    
     if(Serial.available() > 0){
     status_iluminacao_jardim = Serial.read();
     }
     
    //status_iluminacao_jardim = digitalRead(iluminacao_jardim);
   // status_iluminacao_sala_alta = digitalRead(iluminacao_sala_alta);

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
          if(status_iluminacao_jardim == 1){
            client.println("<img src='http://localhost/autonomos/img/off.png'/>");
          }
          else if (status_iluminacao_jardim == 0){
                client.println("<img src='http://localhost/autonomos/img/on.png'/>");
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


            if (readString.indexOf("?iluminacao_jardim_on") >0){
            digitalWrite(iluminacao_jardim, HIGH);
            }
            else if (readString.indexOf("?iluminacao_jardim_off") > 0){
            digitalWrite(iluminacao_jardim, LOW);
           }

            else if (readString.indexOf("?iluminacao_sala_alta_on") > 0){
            digitalWrite(iluminacao_sala_alta, HIGH);
            }



//clearing string for next read
readString="";  
}
}
}
}
}
