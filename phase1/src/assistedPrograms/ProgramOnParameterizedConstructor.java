package assistedPrograms;

public class ProgramOnParameterizedConstructor {

	public static void main(String[] args) {
		
		EmployeesInfo emp1=new EmployeesInfo(2," Alex");
		EmployeesInfo emp2=new EmployeesInfo(10," Annie");
		emp1.display();
		emp2.display();


	}

}

class EmployeesInfo{
	
	int id;
	String name;

	EmployeesInfo(int i,String n){
	
		id=i;
		name=n;
	}

	void display() {
		
		System.out.println(id+" "+name);
	}
}

