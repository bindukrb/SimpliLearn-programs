package assistedPrograms;

public class ProgramOnThrows {

	public static void main(String[] args) {
		

		ProgramOnThrows T = new ProgramOnThrows();
             try
            {
                T.Division();
            }
            catch(ArithmeticException Ex)
            {
                System.out.print("\n\tError : " + Ex.getMessage());
            }
            System.out.print("\n\tEnd of program.");


	}
	
	void Division() throws ArithmeticException
    {
        int a=45,b=0,rs;
        rs = a / b;
        System.out.print("\n\tThe result is : " + rs);
    }


}
