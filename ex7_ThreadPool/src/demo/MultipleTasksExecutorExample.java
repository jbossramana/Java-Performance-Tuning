package demo;

import java.util.concurrent.*;

/**
 * MultipleTasksExecutorExample.java
 * This program demonstrates how to execute multiple tasks
 * with different kinds of executors.
 */
public class MultipleTasksExecutorExample {
 
    public static void main(String[] args) throws InterruptedException {
 
        ExecutorService pool = Executors.newCachedThreadPool();
 
        pool.execute(new CountDownClock("A"));
        pool.execute(new CountDownClock("B"));
        pool.execute(new CountDownClock("C"));
        pool.execute(new CountDownClock("D"));
 
       
        
        
        pool.shutdown();
 
    }
}
