package assistedPrograms;

public class ProgramOnDefaultConstructor {

	public static void main(String[] args) {
		
		EmployeeInfo emp1=new EmployeeInfo();
		EmployeeInfo emp2=new EmployeeInfo();

		emp1.display();
		emp2.display();

	}

}

class EmployeeInfo{
	
	int id;
	String name;

	void display() {
		
		System.out.println(id+" "+name);
	}
}

