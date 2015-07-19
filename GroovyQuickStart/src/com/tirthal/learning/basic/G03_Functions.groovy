package com.tirthal.learning.basic

// =========== RUN SCRIPT FILE USING GROOVY SHELL OR GROOVY CONSOLE ================

// ----------------------> Functions Syntax <--------------------

// ---- Example 1 - Hello world

def sayHello(def name) { // define the function - In input parameter, it is optional to use "def" keyword
    println "The name is: $name"
   
    "Hello $name" // Optionally you may use "return" keyword here, otherwise by default it would be treated as output value of the function
}

def message = sayHello("Tirthal") // calling function sayHello
println "$message" // printing output value of the function

println "..........."

// ---- Example 2 - Add numbers function

def addNumbers(num1, num2) {
    num1 + num2;
}

println "10 + 10 = " + "${addNumbers(10,10)}"