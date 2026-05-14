package demo;
/** This class shows the time taken by string concatenation using + operator and append  */

public class StringDemo2 {

 public static void main(String[] args){

          //Test the String Concatenation using + operator

          long startTime = System.nanoTime();

          
          String result = "hello";

          for(int i=0;i<1500;i++){

        	// String construction with + operator at run-time
        	  
          result += "hello";

          }

 

          long endTime = System.nanoTime();

          System.out.println("Time taken for string concatenation using + operator : "

                                          + (endTime - startTime)+ " nano seconds");

 

 

          //Test the String Concatenation using StringBuffer

          long startTime1 = System.nanoTime();
          
          StringBuffer result1 = new StringBuffer("hello");

          for(int i=0;i<1500;i++){

          result1.append("hello");

          }

          long endTime1 = System.nanoTime();

          System.out.println("Time taken for string concatenation using StringBuffer :  "

                                          + (endTime1 - startTime1)+ " nano seconds");

          }
}