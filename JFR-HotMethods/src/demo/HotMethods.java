package demo;
import java.io.IOException;



public class HotMethods {

	private static final int NUMBER_OF_THREADS = 1;



	
	public static void main(String[] args) throws IOException {		
		Thread[] threads = new Thread[NUMBER_OF_THREADS];		
		for (int i = 0; i < threads.length; i++ ) {
			threads[i] = new Thread(new Worker(), "Worker Thread " + i);
			threads[i].setDaemon(true);
			threads[i].start();
		}
		System.out.print("Press enter to quit!");
		System.out.flush();
		System.in.read();		
	}

}
