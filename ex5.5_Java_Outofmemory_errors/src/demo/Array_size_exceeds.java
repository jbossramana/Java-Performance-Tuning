package demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Array_size_exceeds {
	 
	public static void main(String args[]) throws Exception {
		for (int i = 3; i >= 0; i--) {
			try {
				int[] arr = new int[Integer.MAX_VALUE-9];
				System.out.format("Successfully initialized an array with %,d elements.\n", Integer.MAX_VALUE-i);
			} catch (Throwable t) {
				t.printStackTrace();
			}
		}
	  }
	}
