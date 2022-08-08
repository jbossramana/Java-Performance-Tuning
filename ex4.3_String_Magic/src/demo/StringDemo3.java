package demo;
/** This class shows the time taken by string concatenation using + operator and StringBuffer & StringBuilder   */
public class StringDemo3{

    public static void main(String args[])  {
        
        final int ITERATION = 100_000;
        String s = "";
        String s1 = "";

        // String Concatenation using + operator
        long startTime = System.nanoTime();
        for (int i = 0; i < ITERATION; i++) {
            s = s + Integer.toString(i);
        }
        long duration = (System.nanoTime() - startTime) / 1000;
        System.out.println("Time taken to concatenate 100000 Strings using + operator (in micro) : " + duration);

        // Using String concat() method
        startTime = System.nanoTime();
        for (int i = 0; i < ITERATION; i++) {
            s1.concat(Integer.toString(i));

        }
        duration = (System.nanoTime() - startTime) / 1000;
        System.out.println("Time taken to concatenate 100000 Strings using concat method (in micro) : " + duration);
        
    // StringBuffer example to concate String in Java
        StringBuffer buffer = new StringBuffer(); // default size 16
        startTime = System.nanoTime();
        for (int i = 0; i < ITERATION; i++) {
            buffer.append(i);
        }

        duration = (System.nanoTime() - startTime) / 1000;
        System.out.println("Time taken to concatenate 100000 Strings using StringBuffer (in micro) : " + duration);

        // StringBuilder example to concate two String in Java
        StringBuilder builder = new StringBuilder(); //default size for worst case
        startTime = System.nanoTime();
        for (int i = 0; i < ITERATION; i++) {
            builder.append(i);
        }
        duration = (System.nanoTime() - startTime) / 1000;
        System.out.println("Time taken to concatenate 100000 Strings using StringBuilder append in micro) : " + duration);
    }
}


