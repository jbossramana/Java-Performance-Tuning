package demo;

import java.util.ArrayList;
import java.util.List;

// the while loop will lead to high CPU and memory usage

public class Allocator2 {

	public static void main(String[] args) {
	    List<Object> items = new ArrayList<>(1);
	    try {
	        while (true){
	            items.add(new Object());
	            
	        }
	    } catch (OutOfMemoryError e){
	        System.out.println(e.getMessage());
	    }
	  
	}
	
}
