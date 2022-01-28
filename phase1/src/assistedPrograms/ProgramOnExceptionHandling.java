package assistedPrograms;

public class ProgramOnExceptionHandling extends Exception {

	public static void main(String[] args) {
		
		try {
			
			System.out.println("Starting of try block");
			throw new MyExceptions("This is My error Message");
		}
		catch(MyExceptions exp){
			System.out.println("Catch Block") ;
			System.out.println(exp) ;
		}

	}

}

class MyExceptions extends Exception{
	   String str1;
	   MyExceptions(String str2) {
		str1=str2;
	   }
	   public String toString(){ 
		   
		return ("MyException Occurred: "+str1) ;
	   }
	}
