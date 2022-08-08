package demo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.StampedLock;

public class StampedLockTest {

	public static void main(String[] args) throws InterruptedException
	  
	{
		ExecutorService executor = Executors.newFixedThreadPool(2);
		Map<String, String> map = new HashMap<>();
		StampedLock lock = new StampedLock();

		executor.submit(() -> {
		    long stamp = lock.writeLock();
		    try {
		       try {
				Thread.sleep(1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        map.put("foo", "bar");
		    } finally {
		        lock.unlockWrite(stamp);
		    }
		});

		Runnable readTask = () -> {
		    long stamp = lock.readLock();
		    try {
		    	System.out.println("Optimistic Lock Valid: " + lock.validate(stamp));
		        System.out.println(map.get("foo"));
		        try {
					Thread.sleep(1);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    } finally {
		        lock.unlockRead(stamp);
		    }
		};

		executor.submit(readTask);
		executor.submit(readTask);

	
	}
}
