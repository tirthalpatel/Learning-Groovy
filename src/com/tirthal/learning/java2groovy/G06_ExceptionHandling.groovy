package com.tirthal.learning.java2groovy

// ------ Method in Groovy - Any exception you don’t handle is automatically passed on to a higher level
def openFile(fileName) {

	// In Java - developer are enforced to handle exceptions thrown e.g. FileNotFoundException, SecurityException
	// In Groovy - not force you to handle exceptions that you don’t want to handle or that are inappropriate at your level.
	new FileInputStream(fileName)

}


// ------ Calling method - catching FileNotFoundException exception
try
{
	openFile("nonexistentfile" )
}
catch(FileNotFoundException ex)
{
	// Do whatever you like about this exception here
	println "Oops: " + ex
}

// ------ Calling method - catching all Exceptions that may be thrown
try
{
	openFile("nonexistentfile" )
}
catch(ex)
{
	// Do whatever you like about this exception here
	println "Oops: " + ex
}

// ------ Calling method - catching all exceptions including Error or Throwable
try
{
	openFile("nonexistentfile" )
}
catch(Throwable t)
{
	// Do whatever you like about this exception here
	println "Oops: " + t
}