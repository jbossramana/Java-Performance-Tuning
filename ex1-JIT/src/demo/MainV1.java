package demo;


public class MainV1 {

    public static void main(String[] args) throws InterruptedException {
        
        long start = System.nanoTime();
        
    
        
         for (int outer=1;outer<=1000;outer++)
        {
            
            testPerformance();
           
        }
        
        long duration = System.nanoTime()-start;
        System.out.println("Total time: " + duration);
      //  Thread.sleep(100000);
       
    }
 
    private static void testPerformance() {
        long sum = 0;
        for (int i = 1; i <= 500; i++)
        {
            sum = sum + random(i);
        }
    }
 
    private static int random(int i) {
        int x = (int)(i*2.3d/2.7d); // This is a simulation
        int y = (int)(i*2.36d);     // of time-consuming
        return x%y;                 // business logic.
    }
}