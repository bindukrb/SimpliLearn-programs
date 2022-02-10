package learners;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AlloteClass", urlPatterns = { "/alloteClass" })
public class AllotClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		String qry;
		PrintWriter out = response.getWriter();
		DBConfig config=new DBConfig();
		out.println("The classes are :<br>");
		qry = "select * from class";
		try {
		config.pstmt = config.dbCon.prepareStatement(qry);
		config.theResultSet = config.pstmt.executeQuery();
		while(config.theResultSet.next()) {
		out.println("The Class Id : "+config.theResultSet.getInt("class_id")+" and the class name is "+config.theResultSet.getString("class_name"));
		out.println("<br>");
		}
		} catch (SQLException e) {
		System.out.println("Error in query"+e.getMessage());
		}
		out.println("<br>The Subjects are :");
		qry = "select * from subject";
		try {
		config.pstmt = config.dbCon.prepareStatement(qry);
		config.theResultSet = config.pstmt.executeQuery();
		while(config.theResultSet.next()) {
		out.println("The Subject Id :"+config.theResultSet.getInt("subject_id")+" and the Subject name is "+config.theResultSet.getString("subject_name"));
		out.println("<br>");
		}
		} catch (SQLException e) {
		System.out.println("Error in query"+e.getMessage());
		}
		out.println("<br>");
		RequestDispatcher dispatcher = request.getRequestDispatcher("assign.html");
		dispatcher.include(request, response);
	}

	

}
