package assistedPrograms;

public class ProgramOnThrow {

	public static void main(String[] args) {
		
		int a=45,b=0,result;

        try
        {
            if(b==0)        
                throw(new ArithmeticException("Can't divide by zero."));
            else
            {
                result = a / b;
                System.out.print("\n\tThe result is : " + result);
            }
        }
        catch(ArithmeticException Ex)
        {
            System.out.print("\n\tError : " + Ex.getMessage());
        }

        System.out.print("\n\tEnd of program.");


	}

}
