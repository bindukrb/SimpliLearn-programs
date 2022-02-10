package tracking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/save")
public class Save extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

//		Get the userName from request
		String userName = request.getParameter("userName");

//		Get the session reference
		HttpSession session = request.getSession();

//		Save the value into session
		session.setAttribute("userName", userName);

//		Forward to the dashboard
		response.sendRedirect("dashboard");
	}

}
