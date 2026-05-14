package demo;

public class Sample2 {
   String name;
   Sample2(String name){
      this.name = name;
   }
   protected void finalize() throws Throwable {
      System.out.println(this.name + " successfully garbage collected");
   }
   public static void main(String args[]){
      Sample2 obj = new Sample2("myObject1");
      obj = new Sample2("myObject2");
      System.gc();
    
   }
}