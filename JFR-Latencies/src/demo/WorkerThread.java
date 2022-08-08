package demo;
public class WorkerThread extends Thread {
	public final static Logger LOGGER = Logger.getLogger();

	private int loopCount;

	public WorkerThread(int id, int loopCount) {
		super("Worker Thread " + id);
		this.loopCount = loopCount;
	}

	public void run() {
		while (true) {
			
			int x = 1;
			int y = 1;
			for (int i = 1; i < loopCount; i++) {
				x += 1;
				y = y % (this.loopCount + 3);
				if (x % (this.loopCount + 4) == 0 || y == 0) {
					System.out.println("Should not happen");
				}
			}
		
			LOGGER.log("Thread reporting work done");
			Thread.yield();
		}
		
	}
}
