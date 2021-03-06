package com.ipartek.ejemplos.joseba.chat;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/chatver")
public class ChatVerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(); // Creas la sesion

		String nombre = (String) session.getAttribute("nombre"); // Recoges el valor de la
																	// sesion nombre,las
																	// sesiones siempre
																	// son las mismas

		ServletContext application = getServletContext(); // Creas un variables global
		String texto = (String) application.getAttribute("texto"); // Recoges el valor

		PrintWriter out = response.getWriter();

		if (texto == null) {

			texto = "Empezando a chatear...";
		}

		out.println("<html>");
		out.println("<head>");
		out.println("<h1>El Chat</h1>");
		out.println("<head>");
		out.println("<body>");
		out.println("<br>");

		out.println("</body>");

		out.println("</html>");
		out.println(nombre + ": " + texto + "<br>");

		response.setContentType("text/html");

		out.println("<html>");
		out.println("<head>");
		out.println("<head>");
		out.println("<body>");
		out.println("<br>");
		out.println("<a href='chattexto.html'>Escribir texto</a>");
		out.println("<a href='chatalta.html'>Nuevo Usuario</a>");
		out.println("<a href='baneado.html'>Banear todos</a>");

		out.println("</body>");

		out.println("</html>");

	}
}
