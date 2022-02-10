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
import javax.servlet.http.HttpSession;


@WebServlet("/teachersubjectallotment")
public class TeacherSubjectAllotment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		boolean flag=false;
		String qry;
		
		PrintWriter out = response.getWriter();
		DBConfig config=new DBConfig();
		HttpSession session=request.getSession();
		
		String subId = request.getParameter("subId");
		String classId=(String) session.getAttribute("classId");
		String teaId=(String) session.getAttribute("teaId");
		qry="select s.subject_id AS subject_id,s.subject_name AS subject_name from subject AS s,class_subject AS cs where (s.subject_id=cs.subject_id) AND (cs.class_id=?)";
		flag=false;
		try {
			config.pstmt=config.dbCon.prepareStatement(qry);
			config.theResultSet = config.pstmt.executeQuery();
			while(config.theResultSet.next()) {
				if(config.theResultSet.getString("subject_id")==subId) {
				flag=true;
				}
			}
		} catch (SQLException e) {
		
		e.printStackTrace();
		}
		
		if(!flag) {
			out.println("You have entered the wrong subject code <br> Try again");
			out.println("<br>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
			dispatcher.include(request, response);
			}
		qry="insert into teacher_class_subject values(?,?,?)";
		try 
		{
			config.pstmt=config.dbCon.prepareStatement(qry);
			config.pstmt.setString(1, teaId);
			config.pstmt.setString(2, classId);
			config.pstmt.setString(3, subId);
			
			if(config.pstmt.executeUpdate()>0) {
				out.println("The teacher is assigned to the subject");
			}
		} 
		catch (SQLException e) {
			out.println("Wrong id");
		}

	}

}
