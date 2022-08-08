package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionExample {

	public static void main(String args[]){
	    Function<Employee, String> funcEmpToString= (Employee e)-> {return e.getName();};
	    List<Employee> employeeList= 
	     Arrays.asList(new Employee("gopi", 45), 
	      new Employee("mani", 25),
	      new Employee("rushi", 30),
	      new Employee("Smith", 25),
	      new Employee("krishna", 29));
	    List<String> empNameList=convertEmpListToNamesList(employeeList, funcEmpToString);
	    empNameList.forEach(System.out::println);
	 }
	 public static List<String> convertEmpListToNamesList(List<Employee> employeeList, Function<Employee, String> funcEmpToString){
	   List<String> empNameList=new ArrayList<String>(); 
	   for(Employee emp:employeeList){
	     empNameList.add(funcEmpToString.apply(emp));
	   }
	   return empNameList;
	  }
}


 class Employee
{
String name;
int age;

public Employee(String n, int a) {
	name=n;
	age=a;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}

}