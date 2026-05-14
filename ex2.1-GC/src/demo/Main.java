package demo;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Runtime runtime = Runtime.getRuntime();

        System.out.println("=== Initial Memory ===");
        printMemory(runtime);

        List<Customer> customers = new ArrayList<>();

        // Create many objects so memory usage becomes visible
        for (int i = 0; i < 5_000_000; i++) {
            customers.add(new Customer("Customer " + i));
        }

        System.out.println("\n=== After Creating Customers ===");
        printMemory(runtime);

        // Remove reference to objects
        customers = null;

        System.out.println("\n=== After Removing Reference ===");
        printMemory(runtime);

        // Wait a little before GC
        Thread.sleep(2000);

        System.out.println("\n=== Before GC ===");
        printMemory(runtime);

        // Request garbage collection
        System.gc();

        // Give GC some time
        Thread.sleep(2000);

        System.out.println("\n=== After GC ===");
        printMemory(runtime);

        // Keep application alive for observation
        Thread.sleep(10000);
    }

    private static void printMemory(Runtime runtime) {

        long totalMemory = runtime.totalMemory() / 1024;
        long freeMemory = runtime.freeMemory() / 1024;
        long usedMemory = totalMemory - freeMemory;
        long maxMemory = runtime.maxMemory() / 1024;

        System.out.println("Total Memory : " + totalMemory + " KB");
        System.out.println("Free Memory  : " + freeMemory + " KB");
        System.out.println("Used Memory  : " + usedMemory + " KB");
        System.out.println("Max Memory   : " + maxMemory + " KB");
    }
}