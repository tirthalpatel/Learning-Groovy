package com.tirthal.learning.basic

// =========== RUN SCRIPT FILE USING GROOVY SHELL OR GROOVY CONSOLE ================

// ----------------------> Dynamic Capabilities of Groovy <--------------------

// Why Groovy is dynamically typed? - Because compile would not check for type safety, instead it will be taken care at runtime
// Groovy is a dynamic language, so you don’t have to specify the type of the variable you’re declaring (or returning).

def v1 = "Hello"
def v2 = 10
Integer v3 = 15 // Not recommended to assign values statically, instead use power of "def" of dynamically typed

print v1 + " - " + v1.getClass() + " - "
println v1.toUpperCase()

println v2 + " - " + v2.getClass()
// v2.toUpperCase() // --- Sorry this will give groovy.lang.MissingMethodException, as v2 is assigned Integer type at runtime

v2 = "World" // You can change it dynamically to assign String at runtime. This is the power of dynamic typed language.
print v2 + " - " + v2.getClass() + " - "
println v2.toUpperCase()

println v3 + " - " + v3.getClass()
// v3.toUpperCase() // --- Sorry this would give MissingMethodException exception, as v2 is assigned Integer type at runtime
// v3 = "Not possible" // --- Sorry this is not possible, as it would give exception - org.codehaus.groovy.runtime.typehandling.GroovyCastException

// Groovy does support static types as well
Date x = new Date();
println x

// -----------------------------------------------------------------------------------------------------------
// ------- "Design by Capability" using Dynamic typing instead of Design by contract/interface approach ------
// -----------------------------------------------------------------------------------------------------------
// The payment() method accepts a paymentMode but does not specify its type, rather it defaults to an Object
class CreditCard {
	void pay() {
		println "paying using credit card..."
	}
}

class DebitCard {
	void pay() {
		println "paying using debit card..."
	}
}

class Cash {
	// Sorry not having capability to pay
}

def payment(paymentMode) { // This is not an design by contract, rather design by capability implementation
	if(paymentMode.metaClass.respondsTo(paymentMode, "pay")) {	// check if paymentMode is having capability to pay?
		paymentMode.pay();
	}	
}

payment(new CreditCard())
payment(new DebitCard())
payment(new Cash())