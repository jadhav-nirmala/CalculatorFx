package application;

class DivideByZeroException extends Exception {
   public DivideByZeroException(String message) {
      super(message);
   }
}

public class Calculator {
	
	public Calculator() {
		
	}
	
	public double add(double a, double b) {
		return a+b;
	}
	
	public double subtract(double a, double b) {
		return a-b;
	}
	
	public double multiply(double a, double b) {
		return a*b;
	}
	
	public double divide(double a, double b) {
		try {
			if(b == 0) throw new DivideByZeroException("Error: Cannot divide a number by zero.");
			return a/b;
		} catch(DivideByZeroException  e) {
			System.out.println(e.getMessage());
	        return Double.POSITIVE_INFINITY;
		}
	}
	
	public double modulo(double a, double b) {
		return a%b;
	}

}
