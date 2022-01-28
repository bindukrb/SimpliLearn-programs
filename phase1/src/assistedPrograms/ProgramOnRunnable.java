package assistedPrograms;

public class ProgramOnRunnable implements Runnable {
	public static int myCount = 0;

	public static void main(String[] args) {
		
        System.out.println("Starting Main Thread...");
        ProgramOnRunnable mrt = new ProgramOnRunnable();
        Thread t = new Thread(mrt);
        t.start();
        while(ProgramOnRunnable.myCount <= 10){
            try{
                System.out.println("Main Thread: "+(++ProgramOnRunnable.myCount));
                Thread.sleep(100);
            } catch (InterruptedException iex){
                System.out.println("Exception in main thread: "+iex.getMessage());
            }
        }
        System.out.println("End of Main Thread...");
    


	}
	
    public ProgramOnRunnable(){
         
    }
    public void run() {
        while(ProgramOnRunnable.myCount <= 10){
            try{
                System.out.println("Expl Thread: "+(++ProgramOnRunnable.myCount));
                Thread.sleep(100);
            } catch (InterruptedException iex) {
                System.out.println("Exception in thread: "+iex.getMessage());
            }
        }
    } 


}
