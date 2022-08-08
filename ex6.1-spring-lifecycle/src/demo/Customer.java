package demo;



import javax.annotation.PostConstruct;

import org.springframework.beans.factory.InitializingBean;

public class Customer implements InitializingBean {

	String name="No Name";

	public Customer()
	{
		System.out.println("Lifecycle1...Instantiate");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("Lifecycle2 ... dependency injection");
		this.name = name;
		
	}

	@PostConstruct
	public void init()
	{
		System.out.println("Lifecycle5...@Postconstruct method(Customer)");
	}
	
	public void start()
	{
	System.out.println("Lifecycle7...custom init method");	
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Lifecycle6...InitializingBean");
	}
	
}
