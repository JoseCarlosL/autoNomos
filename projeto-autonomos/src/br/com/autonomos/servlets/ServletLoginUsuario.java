package br.com.autonomos.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.autonomos.dao.ConnectionValidaLoginUsuario;
import br.com.autonomos.modelo.Usuario;

@WebServlet("/ServletLoginUsuario")
public class ServletLoginUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletLoginUsuario() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ConnectionValidaLoginUsuario user = new ConnectionValidaLoginUsuario();
		List<Usuario> usuario = null;
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		try {
			usuario = user.verificarUsuario(email, senha);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		for (Usuario u : usuario) {
			if (u.getEmail().equals(email) && u.getSenha().equals(senha)) {
				String url = "http://localhost:8080/ClasseWeb/platClient.html";
				response.sendRedirect(url);
			} else {

			}
		}
	}
}
