

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import DBConnection;


@WebServlet("/DemoJDBC")
public class DemoJDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DemoJDBC() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            
           InputStream in = getServletContext().getResourceAsStream("/WEB-INF/lib/com.mysql.jdbc.Driver");
           Properties props = new Properties();
           //props.load(in);
           
           DBConnection conn = new DBConnection(props.getProperty("jdbc:mysql://localhost:3306/family"), props.getProperty("root"), props.getProperty("bindu"));
           out.println("DB Connection initialized.<br>");
           
           conn.closeConnection();
           out.println("DB Connection closed.<br>");
           
           
           out.println("</body></html>");
           conn.closeConnection();
           
   } catch (ClassNotFoundException e) {
           e.printStackTrace();
   } catch (SQLException e) {
           e.printStackTrace();
   }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
