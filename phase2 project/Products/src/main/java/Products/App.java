package Products;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        
    	SessionFactory factory =new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(productdetails.class).buildSessionFactory();
        
        Session theSession=factory.getCurrentSession();
        
       newRecordFromRunTime(theSession);
       // addNewUser(factory, theSession);
        
    }
    
    private static void newRecordFromRunTime(Session theSession) {
    
    	 Scanner scan=new Scanner(System.in);
     	
		   System.out.println("Enter p_id to be added..");
		   int p_id=scan.nextInt();
		   
		   scan.nextLine();
		   
		   System.out.println("Enter product name to be added..");
		   String name=scan.nextLine();
		   
		   System.out.println("Enter product price to be added..");
		   int price=scan.nextInt();
		   
		   // Create a User object
		   productdetails newProduct = new productdetails(p_id, name, price);
		   
		   //  Start the transaction
		   theSession.beginTransaction();
		   
		   //	Save the user
		   theSession.save(newProduct);

		   // Commit the transaction
			theSession.getTransaction().commit();
			
			System.out.println("product added successfully");
    	
	
	}
    
   
}
