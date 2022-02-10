package learners;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/report")
public class Classreport extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		String qry;
		PrintWriter out = response.getWriter();
		
		DBConfig config=new DBConfig();
		
		boolean flag = false;
		flag=false;
		qry="select * from class";
		
		try {
			config.pstmt=config.dbCon.prepareStatement(qry);
		} catch (SQLException e1) {
			out.println("SQL error");
		}
		
		try {
			config.theResultSet = config.pstmt.executeQuery();
		} catch (SQLException e1) {
			out.println("SQL error");
		}
		
		try {
			while(config.theResultSet.next()) {
			out.println("Class:"+config.theResultSet.getString("class_name"));
			out.println("<br>");
			
			int i=config.theResultSet.getInt("class_id");
			
			qry="select student_name from students where class_id=?";
			config.pstmt=config.dbCon.prepareStatement(qry);
			config.pstmt.setInt(1, i);
			config.secondResultSet=config.pstmt.executeQuery();
			out.println("The students list:");out.println("<br>");
			
			while(config.secondResultSet.next()) {
				out.println(config.secondResultSet.getString("student_name"));
				out.println("<br>");
				flag=true;
		}
			
		if(!flag) {
			out.println("No students are there in this class");
			out.println("<br>");
			}
		flag=false;
		out.println("<br>");
		qry="select s.subject_name from subject AS s, class_subject AS cs where (s.subject_id = cs.subject_id) AND (cs.class_id=?)";
		config.pstmt=config.dbCon.prepareStatement(qry);
		config.pstmt.setInt(1, i);
		config.secondResultSet=config.pstmt.executeQuery();
		out.println("The subject list is:");out.println("<br>");
		
		while(config.secondResultSet.next()) {
			out.println(config.secondResultSet.getString("subject_name"));out.println("<br>");
			flag=true;
		}
		
		if(!flag) {
			out.println("No subjects are assigned to this class");out.println("<br>");}
			flag=false;
			out.println("<br>");
			qry="select t.teacher_name AS teacher,s.subject_name AS subject from teacher t , teacher_class_subject tc,subject s where (t.teacher_id = tc.teacher_id) AND (s.subject_id = tc.sub_id) AND (tc.class_id = ?)";
			config.pstmt=config.dbCon.prepareStatement(qry);
			config.pstmt.setInt(1, i);
			config.secondResultSet=config.pstmt.executeQuery();
			out.println("The teacher list is :");out.println("<br>");
			while(config.secondResultSet.next()) {
				out.println(config.secondResultSet.getString("teacher")+" teaches "+config.secondResultSet.getString("subject"));
				out.println("<br>");
				flag=true;
		}
		if(!flag) {
		out.println("No subjects are assigned to this class");out.println("<br>");}
		flag=false;
		out.println("<br>");
		}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}

		}
		

}
