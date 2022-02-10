package jsp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/app")
public class App extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  
		  String p_id = request.getParameter("p_id");
		  String name = request.getParameter("name");
		  String price = request.getParameter("price");
		  
		  HttpSession theSession = request.getSession();
		  
		  theSession.setAttribute("p_id", p_id);
		  theSession.setAttribute("name", name);
		  theSession.setAttribute("price", price);
		  
		  response.sendRedirect("display.jsp");
		  

	}

}
