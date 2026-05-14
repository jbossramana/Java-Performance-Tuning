package demo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest
{
	 static float amt=10;
	 public static void main(String[] args) throws InterruptedException
	   {
		
		 ExecutorService executor = Executors.newFixedThreadPool(2);
		 Map<String, String> map = new HashMap<>();
		 ReadWriteLock lock = new ReentrantReadWriteLock();

		 
		 
	
		 executor.submit(() -> {
			 
		     lock.writeLock().lock();
		     
		     try {
		         try {
		        	
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		         map.put("foo", "bar");
		         System.out.println("Writelock is obtained");
		         Thread.sleep(5000);
		     } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
		         lock.writeLock().unlock();
		     }
		 });
	   
	 
	 Runnable readTask = () -> {
			amt++;
		 //  	 System.out.println("amount "+amt);
		    lock.readLock().lock();
		    try {
		    
		    	  System.out.println("Readlock is obtained");
		        System.out.println(map.get("foo"));
		        try {
					Thread.sleep(100000);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    } finally {
		        lock.readLock().unlock();
		    }
		};

		executor.submit(readTask);
		executor.submit(readTask);
	   }
}
