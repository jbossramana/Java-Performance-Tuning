package demo;

public class StringDemo1 {

	/** This class shows the time taken by string concatenation */

	

	 public static void main(String[] args){

	           //Test the String Concatination

	          long startTime = System.nanoTime();

	      
// String construction with + operator at compile-time
	          
	          String result = "This is"+ "testing the"+ "difference"+ "between"+

	                                "String"+ "and"+ "StringBuffer";
	          
	          // String result =new Sring("This ... StringBuffer").intern();

	       

	          long endTime = System.nanoTime();

	          System.out.println("Time taken for string concatenation using + operator : "

	                                          + (endTime - startTime)+ " nano seconds");

	 

	           //Test the StringBuffer Concatination

	           long startTime1 = System.nanoTime();

	       

	          StringBuffer result2 = new StringBuffer();

	                             result2.append("This is");

	                            result2.append("testing the");

	                            result2.append("difference");

	                            result2.append("between");

	                           result2.append("String");

	                           result2.append("and");

	                           result2.append("StringBuffer");

	        

	 

	          long endTime1 = System.nanoTime();

	          System.out.println("Time taken for String concatenation using StringBuffer : "

	                                             + (endTime1 - startTime1)+ " nano seconds");

	 }

	}

