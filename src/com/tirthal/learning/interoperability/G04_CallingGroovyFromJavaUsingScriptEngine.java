package com.tirthal.learning.interoperability;

import groovy.lang.Binding;
import groovy.util.GroovyScriptEngine;
import groovy.util.ResourceException;
import groovy.util.ScriptException;
import java.io.IOException;

/*
 * Calling Groovy from inside a Java application requires the Groovy JAR and other related JARs to be 
 * put into your Java application’s CLASSPATH, as they’re runtime dependencies.
 * 
 * TIP --- Simply put the GROOVY_HOME/embeddable/groovy-all-1.8.6.jar file into your CLASSPATH.
 */

/**
 * * The example code of calling Groovy from Java using GroovyScriptEngine
 * 
 * If you have a larger amount of Groovy code that you need to access, then
 * using the complete GroovyScriptEngine is the recommended option.
 * 
 * When you use the GroovyScriptEngine, you specify the URL or directory
 * location of your Groovy code. The engine then loads and compiles those
 * scripts as necessary, including dependent scripts. For example, if you change
 * script B and script A is reliant on B, the engine will recompile the whole
 * lot.
 * 
 * @author tirthalp
 * 
 */
public class G04_CallingGroovyFromJavaUsingScriptEngine {

	public static void main(String[] args)
	{
		try {
			String[] roots = new String[] {"src/com/tirthal/learning/interoperability"}; // Set roots 
			GroovyScriptEngine gse = new GroovyScriptEngine (roots); // Initialize	Engine
			
			Binding binding = new Binding();
			binding.setVariable("name", "Tirthal");
			
			Object output = gse.run("G04_Hello.groovy", binding); // Run script
			
			System.out.println(output.toString());
			
			assert output.equals("Hello Tirthal");
		}
		catch (IOException | ResourceException | ScriptException e) {
			System.out.println(e.getMessage());
		}
	}
}
