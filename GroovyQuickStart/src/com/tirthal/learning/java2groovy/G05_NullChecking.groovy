package com.tirthal.learning.java2groovy

// Define foo method in groovy
def foo(str) {
	
	// ------ Java way of null handling
	// if(str != null) { return str.reverse() } 
	
	// ------ Groovy way - using safe navigation operator (?.), it results in a null instead of NullPointerException
	str?.reverse()
}

println foo('tirthal')

println foo(null)