package com.tirthal.learning.java2groovy;

/*
 * DEFAULT IMPORTS:
 * 
 * You don’t have to import some common classes/packages when you write Groovy code. 
 * For example, Calendar readily refers to java.util.Calendar. 
 * 
 * Groovy automatically imports the following Java packages: 
 * 		java.lang, 
 * 		java.util, 
 * 		java.io,
 * 		java.net. 
 * 
 * It also imports the classes java.math.BigDecimal and java.math.BigInteger. 
 * 
 * In addition, the Groovy packages groovy.lang and groovy.util are imported.
 */

// Java Code - works in Groovy file
public class G01_HelloWorldJavaWay {

	public static void main(String[] args) {

		for(int i=0; i<3; i++) {
			System.out.println("Hello World");
		}
	}
}
