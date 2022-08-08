package demo;


import java.util.*;

public class ContainsTest {
	
	
	public void check(Collection<String> c)
	{
		c.add("Learning"); 
		   c.add("Easy");
		   c.add("Simply");  
		   c.add("test");
		   c.add("great");
		      
		   // check the existence of element
		   long startTime = System.nanoTime();
		   boolean exist=c.contains("Simply");
		         
		   long endTime = System.nanoTime();

		   System.out.println("Time taken for the execution of contains() method "

		                                   + (endTime - startTime)+ " nano seconds");
		   
		   System.out.println("Is the element 'Simply' exists: "+ exist);
		
	}
	
   public static void main(String args[]) {
	   
	   ContainsTest demo = new ContainsTest();
   // create hash set
   HashSet <String> set1 = new HashSet <String>();
   System.out.println("DEMO using HashSet");
   demo.check(set1);
   
	LinkedList<String> list1 = new LinkedList<String>();
	 System.out.println("DEMO using LinkedList");
         demo.check(list1);   
   // populate hash set
   
   }    
}