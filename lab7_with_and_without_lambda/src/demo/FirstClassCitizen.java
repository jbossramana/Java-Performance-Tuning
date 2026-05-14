package demo;

public class FirstClassCitizen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calculator<Integer,Integer> cal = (a,b) -> a + b;
		
		System.out.println(cal.add(10,20));
		
		printSum(cal);
		
		Calculator<Integer, Integer> multiplier = getCalculatorFunc();
		
		Integer result = multiplier.add(6,9);
		System.out.println("result :" + result);
		
	}

	static void printSum(Calculator cal) {
	    System.out.println(cal.add(4,5));
	}
	
	static Calculator getCalculatorFunc() {
	    Calculator<Integer, Integer> multiplier = (a, b) -> a * b;
	    return multiplier;
	}
	
}
