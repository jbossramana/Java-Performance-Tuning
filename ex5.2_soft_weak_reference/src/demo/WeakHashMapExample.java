package demo;

import java.util.HashMap;
import java.util.WeakHashMap;

//Try with HashMap & WeakHashMap with & withoud System.gc()

public class WeakHashMapExample {

	public static void main(String args[]) throws InterruptedException
	{
		
	WeakHashMap<Integer, String> map = new WeakHashMap<>();
	//	HashMap<Integer, String> map = new HashMap<>();
		
		String  bigImage = new String("God Image");
		Integer imageId = new Integer(1001);
		 
		map.put(imageId, bigImage);
		System.out.println(" image size: " + map.size());
		 
	imageId = null;
		
		System.out.println("search image : " + map.size());
		
		System.out.println("get image " + map.get(1001));
		
		
	//System.gc();
		
		//Thread.sleep(1000);
		 
		System.out.println("search image : " + map.size());
		System.out.println("get image " + map.get(1001));
	}
}
