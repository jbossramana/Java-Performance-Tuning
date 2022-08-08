package demo;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class TestClientWeak {

	public static void main(String[] args) {
		
		StringBuilder builder = new StringBuilder("abc");
		WeakReference<StringBuilder> reference1 = new WeakReference<>(builder);
		
		System.out.println("before strong value is: "+ builder);
		
		builder=null;
		
	    System.gc();
		
		System.out.println("after strong value is: "+ builder);
		
		//Each time we work with this kind of references, we need to make sure 
		//that a referent, returned by the get, is present:
		
		StringBuilder builder2 = reference1.get();
		
		if (builder2 != null) {
		    // GC hasn't removed the instance yet
			System.out.println("weak reference is not null");
		} else {
		    // GC has cleared the instance
			System.out.println("weak reference is  null");
		}
		
		
		

	}

}
