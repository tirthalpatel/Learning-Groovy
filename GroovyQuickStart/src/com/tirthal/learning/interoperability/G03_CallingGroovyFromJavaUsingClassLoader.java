package com.tirthal.learning.interoperability;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.groovy.control.CompilationFailedException;

/*
 * Calling Groovy from inside a Java application requires the Groovy JAR and other related JARs to be 
 * put into your Java application’s CLASSPATH, as they’re runtime dependencies.
 * 
 * TIP --- Simply put the GROOVY_HOME/embeddable/groovy-all-1.8.6.jar file into your CLASSPATH.
 */

/**
 * The example code of calling Groovy from Java using GroovyClassLoader
 * 
 * If you have a full-fledged Groovy class that you want to interact with Java,
 * then you can look at using the GroovyClassLoader. From a developer’s
 * perspective, the GroovyClassLoader behaves much like a Java Class- Loader.
 * You look up the class and the method that you want to call, and simply call
 * it!
 * 
 * This technique will probably be useful if you have a few Groovy utility
 * classes that you want to call out to.
 * 
 * @author tirthalp
 * 
 */
public class G03_CallingGroovyFromJavaUsingClassLoader {
	
	public final static String GROOVY_FILE_PATH = "src/com/tirthal/learning/interoperability/G03_CalculateMax.groovy";
	
	public static void main(String[] args) throws IOException {
		GroovyClassLoader loader = new GroovyClassLoader(); // Prepare ClassLoader
		try {
			
			Class<?> groovyClass = loader.parseClass(new File(GROOVY_FILE_PATH)); // Get Groovy class

			GroovyObject groovyObject = (GroovyObject) groovyClass.newInstance(); // Get instance of Groovy class

			ArrayList<Integer> numbers = new ArrayList<>();
			numbers.add(new Integer(1));
			numbers.add(new Integer(10));
			Object[] arguments = { numbers }; // Prepare arguments

			Object value = groovyObject.invokeMethod("getMax", arguments); // Call Groovy Method
			
			System.out.println(value.toString());
			
			assert value.equals(new Integer(10));
			
		} catch (CompilationFailedException | IOException| InstantiationException | IllegalAccessException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			loader.close();
		}
	}
}
