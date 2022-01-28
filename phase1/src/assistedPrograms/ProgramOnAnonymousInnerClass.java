package assistedPrograms;

public class ProgramOnAnonymousInnerClass {

	public static void main(String[] args) {
		
		AnonymousInnerClass i = new AnonymousInnerClass() {
			
			@Override
	         public void display() {
				
	            System.out.println("This is Anonymous Inner Class");
	            
	         }
	      };
	      
	      i.display();

	}

}

abstract class AnonymousInnerClass {
	
	   public abstract void display();
	   
	}

