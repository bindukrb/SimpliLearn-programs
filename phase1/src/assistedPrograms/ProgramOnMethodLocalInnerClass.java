package assistedPrograms;

public class ProgramOnMethodLocalInnerClass {
	
	private String msg="This is Method-Local Inner Classes";

	 void display(){ 
		 
		 class Inner{
			 
			 void msg(){
				 
				 System.out.println(msg);
			 	
			 } 
			 
		 }  
	  
		 Inner l=new Inner();  
		 l.msg();  
	 }

	public static void main(String[] args) {
		
		ProgramOnMethodLocalInnerClass  ob=new ProgramOnMethodLocalInnerClass ();  
		ob.display();  


	}

}
