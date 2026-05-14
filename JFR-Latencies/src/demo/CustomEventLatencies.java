package demo;




public class CustomEventLatencies {

	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(2000);
		Thread[] threads;
		threads = new Thread[5];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new WorkerThread(i, 30000000);
			threads[i].start();
		}
	}
}
