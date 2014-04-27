package com.tirthal.learning.interoperability

/**
 * Groovy class, which is internally calling Groovy's built-in function
 * @author tirthalp
 *
 */
class G03_CalculateMax {
	def Integer getMax(List values) {
		values.max(); // Calling Groovy’s built-in max function
	}
}
