package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletRelatorio
 */
@WebServlet("/relatorio")
public class ServletRelatorio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String luz = request.getParameter("luz");
		String dataInicio = request.getParameter("dataInicio"); 
		String dataFinal = request.getParameter("dataFinal");
		
		
		try {
			
			SimpleDateFormat formate =  new SimpleDateFormat("yyyy-MM-dd");
			Date dataInic = new Date(formate.parse(dataInicio).getTime());//converte a data inicial para Date
 			out.println(dataInic);
			Date dataFin = new Date(formate.parse(dataFinal).getTime());//converte a data final para Date
			out.println(dataFin);
			
			long resultado = dataFin.getTime() - dataInic.getTime();//compara o tempo entre as datas inicio e fim
			long dias = resultado / 86400000L;//Divide o resultado para pegar apenas o dias de diferença
			out.println(dias);
			out.println(dataFin.compareTo(dataInic));
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if(luz.isEmpty() || luz.equals("")){
			out.println("Checkbox não marcado");
		}else{
			out.print("Checkbox marcado");
		}
			
	}

}
