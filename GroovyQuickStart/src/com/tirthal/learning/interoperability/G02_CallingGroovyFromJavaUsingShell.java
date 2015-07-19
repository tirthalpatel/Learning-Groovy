package com.tirthal.learning.interoperability;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;

import java.math.BigDecimal;

/*
 * Calling Groovy from inside a Java application requires the Groovy JAR and other related JARs to be 
 * put into your Java application’s CLASSPATH, as they’re runtime dependencies.
 * 
 * TIP --- Simply put the GROOVY_HOME/embeddable/groovy-all-1.8.6.jar file into your CLASSPATH.
 */

/**
 * The example code of calling Groovy from Java using GroovyShell
 * 
 * The GroovyShell can be invoked on a temporary basis to quickly call out to
 * Groovy and evaluate some expressions or script-like code. This use of the
 * GroovyShell covers the case where you want to execute a quick bit of Groovy
 * code.
 * 
 * @author tirthalp
 * 
 */
public class G02_CallingGroovyFromJavaUsingShell {

	public static void main(String[] args) {
		//  The following Java code listing will return the value of 10.4 by using Groovy’s numeric literals to perform the addition.
		Binding binding = new Binding();
		binding.setVariable("x", 2.4);
		binding.setVariable("y", 8);

		// Set binding to shell
		GroovyShell shell = new GroovyShell(binding);
		Object value = shell.evaluate("x + y");
		
		System.out.println(value.toString());
		
		// Evaluate and return expression
		assert value.equals(new BigDecimal(10.4));
	}
}