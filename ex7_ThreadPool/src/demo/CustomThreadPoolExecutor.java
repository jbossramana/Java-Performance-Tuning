package demo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomThreadPoolExecutor {

	
	public static void main(String[] args) {
		 
		int corePoolSize = 10;
		int maxPoolSize = 1000;
		int keepAliveTime = 120;
		BlockingQueue<Runnable> workQueue = new SynchronousQueue<Runnable>();
		 
		ThreadPoolExecutor pool = new ThreadPoolExecutor(corePoolSize,
		                         maxPoolSize,
		                         keepAliveTime,
		                         TimeUnit.SECONDS,
		                         workQueue);
 
        pool.execute(new CountDownClock("A"));
        pool.execute(new CountDownClock("B"));
        pool.execute(new CountDownClock("C"));
        pool.execute(new CountDownClock("D"));
 
        pool.shutdown();
 
    }
	
	
}
