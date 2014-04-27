package com.tirthal.learning.basic

// =========== RUN SCRIPT FILE USING GROOVY SHELL OR GROOVY CONSOLE ================

// ----------------------> Closures Syntax / Function Literals <--------------------

// A Groovy Closure is like a "code block" or a method pointer. It is a piece of code that is defined and then executed at a later point.
// It is a representation of a block of code that can be passed around as a value and can be manipulated just like any other value. It can be passed in to methods, assigned to variables, and so on

// ------ Basic fundamental

// Common Java style of static method
class StringUtils
{
    static String sayHello(String name)
    {
        if (name == "Martijn" || name == "Ben")
            "Hello author " + name + "!"
        else
            "Hello reader " + name + "!"
    }
}
println StringUtils.sayHello("Bob");

// Using Closures in Groovy
def sayHello = { name ->                        // name is input parameter supplied to closure code block
    if (name == "Martijn" || name == "Ben")
        "Hello author " + name + "!"
    else
        "Hello reader " + name + "!"
    }
println sayHello("Martijn")

println "----"

// ------ Example 1 - hello world

def closure = {
    println "Hello World at " + new Date()
}

closure() // calling closure code
sleep(1000) // sleep for 1 seconds
closure() // calling closure code again

println "----"

// ------ Example 2 - passing parameters

def sumMsg = "Sum is - " // define free variable
def printSum = { a, b -> println "${sumMsg} ${a+b}" }  // passing a and b parameters

printSum (3, 7)

println "----"

// ------ Example 3 - implicit variable "it"

def printImplicit = {println it}

printImplicit("Hello Tirthal")

println "----"

// ------ Example 4 - Calling closure in loop

def simpleClosure = {println "Inside the closure - " + it} // "it" is implicit variable in Groovy to get value of passing parameter

// for loop

for(i in 1..3) 
    simpleClosure(i) // value of "i" (passing parameter) is assigned to "it" (implicit variable) in closure

// Replace for with each() which accepts the closure as argument

(1..3).each({
    simpleClosure(it)
})

// Even make each() better as single expression

(1..3).each({println "Inside the closure - $it"})

(1..3).each({i -> println "Inside the closure - $i"}) // if don't want to use implicit variable "it", then define custom input parameter such as "i"

println "----"

// ------ Example 5 - Print odd numbers from 1 to 10 numbers range

(1..10).findAll({return it%2 != 0}).each({i -> print "$i "})
println ""

(1..10).findAll({it%2 != 0}).each({print "$it "})
println ""

println "----"

// ------- Example 6 - Assigning closure to the variable

def sum = { n1, n2 -> println "Sum of $n1 and $n2 = " + (n1 + n2)}
sum.call(1,2)

println "----"