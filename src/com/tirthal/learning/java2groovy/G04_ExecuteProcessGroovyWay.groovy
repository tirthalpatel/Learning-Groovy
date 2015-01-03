package com.tirthal.learning.java2groovy

// Groovy extends the JDK with an extension called the GDK or the Groovy JDK

// Below example shows the power of GDK while comparing with java way of code in "G003_ExecuteProcessJavaWay.groovy"

println "cmd /C dir".execute().text
// When you called the execute( ) method on the instance of String,
// Groovy created an instance that extends java.lang.Process, just like the exec( ) method of Runtime did in the Java code

