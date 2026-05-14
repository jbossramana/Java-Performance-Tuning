package demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolExecutor {

	public static void main(String[] args) {
		 
        ExecutorService pool = Executors.newFixedThreadPool(2);
 
        pool.execute(new CountDownClock("A"));
        pool.execute(new CountDownClock("B"));
        pool.execute(new CountDownClock("C"));
        pool.execute(new CountDownClock("D"));
 
        pool.shutdown();
 
    }
}
