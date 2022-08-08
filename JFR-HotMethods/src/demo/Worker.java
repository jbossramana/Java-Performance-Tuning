package demo;

public class Worker implements Runnable {
	private int i = 0;
	
	public void run() {
		while (true) {			
			System.out.println("Count: " + i++);
		
			Initiator i1 = new Initiator();
			Initiator i2 = new Initiator();
			i1.initiate(3);
			i2.initiate(5);
			int intersectionSize = i1.countIntersection(i2);
			
			Thread.yield();
		}
	}
}
