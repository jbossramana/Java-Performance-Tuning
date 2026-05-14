package demo;
import java.util.ArrayList;

public class ResetTest {
    private static final int SIZE = 100_000;
    public static void main(String args[]) {
     
        // Two ArrayList for clear and removeAll
        ArrayList<Integer> numbers = new ArrayList<>(SIZE);
        ArrayList<Integer> integers = new ArrayList<>(SIZE);
        ArrayList<Integer> integers2 = new ArrayList<>(SIZE);
        
        // Initialize ArrayList with 10M integers
        for (int i = 0; i < SIZE; i++) {
            numbers.add(new Integer(i));
            integers.add(new Integer(i));
            integers2.add(new Integer(i));
        }
     
        

        // Empty ArrayList using clear method
        long startTime = System.nanoTime();
        numbers.clear();
        long elapsed = System.nanoTime() - startTime;
        System.out.println("Time taken by clear to empty ArrayList of 1M elements (ns): " + elapsed);
        System.out.println("after clear method, size is : "+numbers.size());
 
        
       // Reset ArrayList using removeAll method
        startTime = System.nanoTime();
        integers.removeAll(integers);
        long time = System.nanoTime() - startTime;
        System.out.println("Time taken by removeAll to reset ArrayList of 1M elements (ns): " + time);
        System.out.println("after removeAll method, size is : "+integers.size());

        
        // Reset ArrayList using removeAll method
        startTime = System.nanoTime();
        integers2=null;
        long time2 = System.nanoTime() - startTime;
        System.out.println("Time taken by null  to reset ArrayList of 1M elements (ns): " + time2);
        System.out.println("after null, size is : "+integers2.size());
        
    }
}


