package assistedPrograms;

public class ProgramOnThreads extends Thread{

	public static void main(String[] args) {
		
		ProgramOnThreads theThread = new  ProgramOnThreads();
  		theThread.start();

	}
	
	@Override
	public void run() {
		
		System.out.println(" thread started running..");
		
	}

}
