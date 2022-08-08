package demo;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class LargeObjectFinalizer extends PhantomReference<Object> {
	 
    public LargeObjectFinalizer(
      Object referent, ReferenceQueue<? super Object> q) {
        super(referent, q);
    }
 
    public void finalizeResources() {
        // free resources
        System.out.println("clearing ...");
    }
}