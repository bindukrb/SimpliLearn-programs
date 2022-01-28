package assistedPrograms;

public class ProgramOnArrays {

	public static void main(String[] args) {
		
		int a[]= {10,20,30,40,50};
		
		System.out.print("Elements of array a:");
		
		for(int i=0;i<5;i++) {
			
			System.out.print(" "+a[i]);
			
		}
		
		int[][] b = { {2, 4, 6, 8}, 
	            	{3, 6, 9} };
	      
	      	System.out.println("\nLength of row 1: " + b[0].length);


	}

}
