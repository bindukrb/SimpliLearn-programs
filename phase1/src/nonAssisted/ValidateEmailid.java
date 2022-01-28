package nonAssisted;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateEmailid {

	public static void main(String[] args) {
		
		ArrayList<String> emailId=new ArrayList<String>();
		
		System.out.println("Here the list of email-Id's: ");
		System.out.println();
		
		
		emailId.add("abcdef@gmail.com");
		emailId.add("ghijkl@hotmail.com"); 
		emailId.add("mnopqr@hotmail.com");
		
	    System.out.println(emailId);
	    System.out.println();
	    
	    Scanner scan=new Scanner(System.in);
	    
	    System.out.println("enter the email-id to search: ");
	    System.out.println();
	    
	    String check=scan.nextLine();
	    
	    for (String element : emailId){
		    if (element.contains(check)){
		        System.out.println("found "+element);	          
		    }		     
		 }
	    
	}

}




