package assistedPrograms;

public class PrivateSpecifier {

	public static void main(String[] args) {
		
		System.out.println("Private Access Specifier");
		PrivateAccessSpecifier  obj = new PrivateAccessSpecifier(); 

	}

}

class PrivateAccessSpecifier 
{ 
   private void display() 
    { 
        System.out.println("You are using private access specifier"); 
    } 
} 

