package br.com.autonomos.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import br.com.autonomos.dao.ConnectionValidaLoginUsuario;
import br.com.autonomos.modelo.Pessoa;
import br.com.autonomos.modelo.Usuario;
import br.com.autonomos.modelo.Visitante;

@WebServlet("/ServletLoginUsuario")
public class ServletLoginUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public String tipo;
	
	public ServletLoginUsuario() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		ConnectionValidaLoginUsuario valida = new ConnectionValidaLoginUsuario();
		
		List<Usuario> usuario = null;
		List<Visitante> visitante = null;
	
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
				
		
		
		//if(email.indexOf("@") != -1){
			
			try {
				usuario = valida.verificarUsuario(email, senha);
				System.out.println(usuario.toString());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			for (Usuario u : usuario) {
				if (u.getEmail().equals(email) && u.getSenha().equals(senha) && u.getTipoPessoa().equals("usuario")) {
					String url = "http://localhost:8080/ClasseWeb/plataformaUsuario.jsp";
					response.sendRedirect(url);
				} else {
					String url = "http://localhost:8080/ClasseWeb/plataformaUsuario.jsp";
					response.sendRedirect(url);
				}
			//}
			
			
		/*} else {
			try {
				visitante = valida.verificarVisitante(email, senha);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			for (Visitante v : visitante) {
				if (v.getEmail().equals(email) && v.getSenha().equals(senha) && v.getTipoPessoa().equals("visitante")) {
					String url = "http://localhost:8080/ClasseWeb/plataformaVisitante.jsp";
					response.sendRedirect(url);
				} else {
					System.out.println("nao foi");
				}
			}
		}
		
		JOptionPane.showMessageDialog(null, "Usuario ou Senha incorreto");
		response.sendRedirect("http://localhost:8080/ClasseWeb/login.html");
	}*/
}}}
