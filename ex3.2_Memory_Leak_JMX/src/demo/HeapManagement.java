package demo;


import java.util.ArrayList;
import java.util.List;

public class HeapManagement implements HeapManagementMBean{

	 List<Account>  acc = new ArrayList<Account>();
	 
	 float amt;
	 
	 
	 
	 public float getAmt() {
		return amt;
	}


	public void setAmt(float amt) {
		this.amt = amt;
	}


	public  void  setData()
	   {

		 System.out.println("frst value: " + acc.size());
		 
		 System.out.println("processors : " + Runtime.getRuntime().availableProcessors());
		 
		 for (int count=0;count <5000;count++){
	    	   Account account = new Account();
		       account.setName("company");
		       account.setType("current");
	    	   account.setId(count);
	    	 
	         acc.add(account);
	       //  System.out.println("value: " + acc.size());
	       }
	   }
	 
	 
	 public void clear()
	 {
		
	//	acc.clear();
		 acc=null;
	//	 System.out.println("size is: "+ acc.size());
	 }
	 
	 public void service1Start() {System.out.println("Service1 started");}
	 public void service1Stop() {System.out.println("Service1 stoped");}
	 
	 
	 public void service2Start() {System.out.println("Service2 started");}
	 public void service2Stop() {System.out.println("Service2 stoped");}
	 
	 
	 
}
