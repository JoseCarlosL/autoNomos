package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.autonomos.modelo.RelatoDeAtendimento;
import br.com.autonomos.modelox.servlet.ServletConfig;
import br.com.autonomos.modelox.servlet.ServletException;
import br.com.autonomos.modelox.servlet.annotation.WebServlet;
import br.com.autonomos.modelox.servlet.http.HttpServlet;
import br.com.autonomos.modelox.servlet.http.HttpServletRequest;
import br.com.autonomos.modelox.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/contato")
public class ServletNovoFormularioContato extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// pegando os parametros da página
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String dataEmTexto = request.getParameter("data");
		Calendar data = null;
		try {
			Date d = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			data = Calendar.getInstance();
			data.setTime(d);
		} catch (ParseException e) {

			System.out.println("Erro na conversão da data.");
		}
		String duvida = request.getParameter("duvida");
		PrintWriter r = response.getWriter();
		r.println("Em breve entraremos em contato com você!");

		//mostras console o que pegou
		System.out.println(nome + email + telefone + dataEmTexto + duvida);

	}

}
