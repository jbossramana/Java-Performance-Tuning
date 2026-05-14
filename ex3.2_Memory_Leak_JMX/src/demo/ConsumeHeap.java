package demo;



import javax.management.*;
import java.lang.management.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class ConsumeHeap {

	
	 static MBeanServer mbs = null;
	
	   public static void main(String []args) throws IOException, InterruptedException, MalformedObjectNameException, InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException{
		   ObjectName helloName = null;
	       
	       mbs = ManagementFactory.getPlatformMBeanServer();
	      
	       
	       helloName = new ObjectName("CustomeMbean:name=HelloBean");
	       
	       HeapManagement account = new HeapManagement();
	       account.setData();
	       mbs.registerMBean(account, helloName);
	       account.service1Start();
	       account.service2Start();
	      
	 //     account.clear();
	      
	      Thread.sleep(500000000);
	      
	   } 
	   
	   
	
	 
	}