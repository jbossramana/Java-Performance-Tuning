package demo;

import java.util.concurrent.*;
 
/**
 * SimpleExecutorExample.java
 * This program demonstrates how to create a single-threaded executor
 * to execute a Runnable task.
 */
public class SimpleExecutorExample {
 
    public static void main(String[] args) {
        ExecutorService pool = Executors.newSingleThreadExecutor();
 
        Runnable task = new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
 
        pool.execute(task);
        pool.execute(task);
        pool.execute(task);
 
        pool.shutdown();
    }
}