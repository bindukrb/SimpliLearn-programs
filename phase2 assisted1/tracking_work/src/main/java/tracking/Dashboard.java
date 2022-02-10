package tracking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/dashboard")
public class Dashboard extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		if (request.getSession().getAttribute("userName") != null) {

			out.println("Welcome " + request.getSession().getAttribute("userName"));

			out.println("<a href='logout'>Logout</>");
		} else {
			out.println("Please login first...");
			
			request.getRequestDispatcher("login.html").include(request, response);
		}
	}

}
