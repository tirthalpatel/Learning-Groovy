package com.tirthal.learning.testing

/**
 * Calculator has add and multiply functionality for supplied two numbers
 * 
 * @author tirthalp
 *
 */
class G01_Calculator {

	// By default everything is public in Groovy. So explicitly making it private.
	private result

	// Constructor
	G01_Calculator() {
		result = 0
	}

	// All method would return java.lang.Object type by default. So making it "void" to return nothing.

	def void add(number1, number2) {
		println "Calculating add numbers"

		if(number1 < 0 || number2 < 0)
			throw new G01_CalculatorNegativeUnsupportedException()

		result = number1 + number2
	}

	def void multiply(number1, number2) {
		println "Calculating multiply numbers"

		if(number1 < 0 || number2 < 0)
			throw new G01_CalculatorNegativeUnsupportedException()

		result = number1 * number2
	}
}