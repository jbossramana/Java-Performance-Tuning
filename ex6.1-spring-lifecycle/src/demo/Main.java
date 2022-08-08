package demo;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;




public class Main
{

   public static void main(String[] args)
      throws Exception
   {
	   
	   

    ApplicationContext ctx = new ClassPathXmlApplicationContext("demo/ApplicationContext.xml");
    
    
    Customer cust = (Customer) ctx.getBean("customer");
    
    System.out.println("name "+ cust.getName());
    
    Account acc = (Account) ctx.getBean("account");
    System.out.println("amount " + acc.amt);
    
   
    
   }
   
}
