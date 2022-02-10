package learners;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/teacher")
public class Teacher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String qry;
		PrintWriter out = response.getWriter();
		DBConfig config=new DBConfig();
		out.println("The Teachers are :");
		qry = "select * from teacher";
		
		try {
			config.pstmt = config.dbCon.prepareStatement(qry);
			config.theResultSet = config.pstmt.executeQuery();
			while(config.theResultSet.next()) {
				out.println("The Teacher Id : "+config.theResultSet.getInt("teacher_id")+" and name of the teacher is "+config.theResultSet.getString("teacher_name"));
			}
		} 
		catch (SQLException e) {
			System.out.println("Error in query"+e.getMessage());
		}

	}

}
