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


@WebServlet("/teaclass")
public class TeacherClassAllotment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		String qry;
		PrintWriter out = response.getWriter();
		DBConfig config=new DBConfig();
		
		boolean flag = false;
		String classId = request.getParameter("classId");
		String teaId = request.getParameter("teaId");
		
		HttpSession session=request.getSession();
		session.setAttribute("classId", classId);
		session.setAttribute("teaId", teaId);
		qry="select s.subject_id AS subject_id,s.subject_name AS subject_name from subject AS s,class_subject AS cs where (s.subject_id=cs.subject_id) AND (cs.class_id=?)";
		try {
			config.pstmt = config.dbCon.prepareStatement(qry);
			config.pstmt.setString(1, classId);
			config.theResultSet = config.pstmt.executeQuery();
			flag=false;
			while(config.theResultSet.next()) {
				out.println("The Subject Id : "+config.theResultSet.getInt("subject_id")+" and the Subject name is "+config.theResultSet.getString("subject_name"));
				out.println("<br>");
				flag=true;
			}
		}
		catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		if(!flag) {
			out.println("No subjects assigned to the class yet<br> assign a subject first to assign a teacher");
			out.println("<br>");
			RequestDispatcher dispatcher = 
			request.getRequestDispatcher("index.html");
			dispatcher.include(request, response);}
			out.println("<br>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("sub.html");
			dispatcher.include(request, response);

	}

}
