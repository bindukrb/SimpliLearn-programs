package assistedPrograms;

public class ClassesAndObjects {
	
	String name; 
    String breed; 
    int age; 
    String color; 

	public static void main(String[] args) {
		
        ClassesAndObjects scott = new ClassesAndObjects("Scott","papillon", 5, "black"); 
        System.out.println(scott.toString()); 


	}  
    
    public ClassesAndObjects(String name, String breed, int age, String color) 
    
    { 
        this.name = name; 
        this.breed = breed; 
        this.age = age; 
        this.color = color; 
    } 
    public String getName() 
    { 
        return name; 
    } 
    public String getBreed() 
    { 
        return breed; 
    } 
    public int getAge() 
    { 
        return age; 
    } 
    public String getColor() 
    { 
        return color; 
    } 
    @Override
    public String toString() 
    { 
        return("Hi my name is "+ this.getName()+ ".\nMy breed is"+ this.getBreed()+","+ "\nAge is " + this.getAge()+"," +"\nand color is "+ this.getColor() + "."); 
    } 


}
