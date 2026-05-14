package demo;

import org.openjdk.jol.info.ClassLayout;

public class MainApp {

	public static void main(String[] args) {
	 
System.out.println(ClassLayout.parseClass(Account.class).toPrintable());

Account instance = new Account();
System.out.println(ClassLayout.parseInstance(instance).toPrintable());
	}

}
