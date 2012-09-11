package com.codexplo.calculator;

public class CaculatorLogic {
	// a method defined for performing addition. it takes two double as
	// parameter and returns addition result
	public double add(double a, double b) {
		return a + b;
	}

	// a method defined for performing subtraction. it takes two double as
	// parameter and returns their subtraction result
	public double substruct(double a, double b) {
		return a - b;
	}

	// a method defined for performing multiplication. it takes two double as
	// parameter and returns their multiplication result
	public double multiply(double a, double b) {
		return a * b;
	}

	// a method defined for performing Division. it takes two double as
	// parameter and returns their division result. if here happen any
	// situation of division by zero, it will return zero ...here I manually
	// handle exception instead of Java exception handling..
	// later on, when you guys learn Exception handling in java, you may use
	// try/catch block
	public double divide(double a, double b) {
		if (b == 0) {
			System.out.println("cant divide by zero");
			return 0;
		} else
			return a / b;
	}

	// this method defined for make string value to double.. its called parsing
	public double stringToDouble(String a) {
		return Double.parseDouble(a);
	}
}
