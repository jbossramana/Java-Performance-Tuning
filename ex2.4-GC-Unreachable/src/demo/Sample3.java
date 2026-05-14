package demo;


public class Sample3 {
   String name;
   Sample3(String name){
      this.name = name;
   }
   
   protected void finalize() throws Throwable {
      System.out.println(this.name + " successfully garbage collected");
   }
   
   public static void main(String args[]) throws InterruptedException{
      Sample3 obj = new Sample3("myObject1");
      obj=null;
      System.gc();
      Thread.sleep(50000);
    
   }
}