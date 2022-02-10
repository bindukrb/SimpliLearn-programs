package learners;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/subject")
public class Subject extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String qry;
		PrintWriter out = response.getWriter();
		DBConfig config=new DBConfig();
		
		out.println("The Subjects are :");
		qry = "select * from subject";
		
		try {
			config.pstmt = config.dbCon.prepareStatement(qry);
			config.theResultSet = config.pstmt.executeQuery();
			while(config.theResultSet.next()) {
				out.println("The Subject Id : "+config.theResultSet.getInt("subject_id")+" and the Subject name is "+config.theResultSet.getString("subject_name"));
			}
		} catch (SQLException e) {
			System.out.println("Error in query"+e.getMessage());
		}

	}

}
