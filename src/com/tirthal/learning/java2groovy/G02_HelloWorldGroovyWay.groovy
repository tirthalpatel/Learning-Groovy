package com.tirthal.learning.java2groovy

// Remove the class and method definition, as not required in Groovy
for(int i = 0; i < 3; i++) {
	System.out.println("Hello World $i")
}

// Other ways of the for loop - in below loop "it" is an implicit variable

// 1 - reduce previous code using the lighter form of for loop that uses the Groovy's Range object
for(i in 0..2) { println "Hello World $i" }

// 2 - Groovy has added a convenient upto() instance method to java.lang.Integer
0.upto(2) { println "Hello World $it" }	// lower limit is set to 0 and upper limit is set to 2

// 3 - start at 0 using the times( ) method
3.times { println "Hello World $it" } // starts with 0

// 4 - skip values while looping, using the step( ) method
0.step(10, 2) { println "Hello World $it " }