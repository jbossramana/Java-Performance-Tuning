package demo;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;

class MainClient {

	public static void main(String args[])
	{
		
		ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
		List<LargeObjectFinalizer> references = new ArrayList<>();
		List<Object> largeObjects = new ArrayList<>();
		 
		for (int i = 0; i < 10; ++i) {
		    Object largeObject = new Object();
		    largeObjects.add(largeObject);
		    references.add(new LargeObjectFinalizer(largeObject, referenceQueue));
		}
		 
		largeObjects = null;
		
		
		
  //System.gc();
		 
		Reference<?> referenceFromQueue;
		for (PhantomReference<Object> reference : references) {
		    System.out.println(reference.isEnqueued());
		}
		 
		while ((referenceFromQueue = referenceQueue.poll()) != null) {
		    ((LargeObjectFinalizer)referenceFromQueue).finalizeResources();
		    referenceFromQueue.clear();
		}
		
		for (PhantomReference<Object> reference : references) {
		    System.out.println(reference.isEnqueued());
		}
		
		
	}
}
