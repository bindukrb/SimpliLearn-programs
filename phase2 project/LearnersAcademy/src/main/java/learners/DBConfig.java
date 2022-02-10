package learners;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConfig {

	
	public static final String URL = "jdbc:mysql://localhost:3306/LearnersAcademy";
	public static final String USERNAME = "root";
	public static final String USERPASS = "";
	
	PreparedStatement pstmt;
	ResultSet theResultSet,secondResultSet;
	Connection dbCon;
	DBConfig(){
		
	try {
		Class.forName("com.mysql.jdbc.Driver");
		dbCon = DriverManager.getConnection(URL, USERNAME, USERPASS);
	} 
	catch (ClassNotFoundException e) {
		System.out.println("Can't load the driver : " + e.getMessage());
	}
	catch (SQLException e) {
		System.out.println("Issues while connecting to db : " + 
		e.getMessage());
		}
	}

}
