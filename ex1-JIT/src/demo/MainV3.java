package demo;


public class MainV3 {

	 public static void main(String[] args) {
	        for (int outer = 1; outer <= 100; outer++) {
	            long start = System.nanoTime();
	            long sum = 10647704;
	            long duration = System.nanoTime() - start;
	            System.out.println("Loop # " + outer + " took " + ((duration) / 1000.0d) + " µs");
	        }
	    }
}
