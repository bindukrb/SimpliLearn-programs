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


@WebServlet("/subclass")
public class SubjectClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		String qry;
		PrintWriter out = response.getWriter();
		DBConfig config=new DBConfig();
		String classId=request.getParameter("classId");
		String subId=request.getParameter("subId");
		qry="insert into class_subject values(?,?)";
		
		try {
			config.pstmt = config.dbCon.prepareStatement(qry);
			config.pstmt.setString(1, classId);
			config.pstmt.setString(2, subId);
		} 
		catch (SQLException e) {
			System.out.println("Error during setting");
		}
		try {
			config.pstmt.executeUpdate();
			out.println("Subject alloted Succesfully");
			out.println("<br>");
			RequestDispatcher dispatcher = 
			request.getRequestDispatcher("index.html");
			dispatcher.include(request, response);
		}
		catch (SQLException e) {
			out.println("Invalid ID's");
			out.println("<br>");
			RequestDispatcher dispatcher = 
			request.getRequestDispatcher("index.html");
			dispatcher.include(request, response);
		}
	}

}
