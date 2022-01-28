package assistedPrograms;

public class ProgramOnRegularInnerClass {
	
	private String msg="Program on Inner Class in Java"; 
	 
	 class Inner{
		 
	  void hello(){
		  
		  System.out.println(msg +",\nthis is Regular Inner Classes");
		  
		  } 
	  
	 }  

	public static void main(String[] args) {
		
		ProgramOnRegularInnerClass obj=new ProgramOnRegularInnerClass();
		ProgramOnRegularInnerClass.Inner in=obj.new Inner();  
		in.hello();  


	}

}
