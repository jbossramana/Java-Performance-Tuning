package demo;


public class Sample {
   String name;
   Sample(String name){
      this.name = name;
   }
   public static void sampleMethod(){
      Sample obj1 = new Sample("myObject2");
      Sample obj2 = new Sample("myObject1");
   }
   protected void finalize() throws Throwable {
      System.out.println(this.name + " successfully garbage collected");
   }
   public static void main(String args[]) throws InterruptedException{
      sampleMethod();
      System.gc();
      Thread.sleep(1000);
   }
}