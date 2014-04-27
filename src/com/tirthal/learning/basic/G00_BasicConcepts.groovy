package com.tirthal.learning.basic

// =========== RUN SCRIPT FILE USING GROOVY SHELL OR GROOVY CONSOLE ================

// -----------------------> Syntax for print messages? <--------------------

System.out.println "Hello World - Can I have easy syntax?"; // Option 1

println("Hello World - Can I simplify the syntax further?"); // Option 2

println "Hello World - Wow, it's easy syntax" // Option 3 - parantheses and semecolon are optional

println "---------"

// -----------------------> Numerics <--------------------

println "3 + 0.5 = " + (3 + 0.5)

println "---------"

// -----------------------> Scoping <--------------------

// Groovy code that’s not inside the usual class and method constructs is considered to be a Groovy script

// A Groovy script has two scopes: 
// (i) binding - The binding is the global scope for the script 
// (ii) local - The local scope is just that—variables are scoped locally to the block that they’re declared in

hello = "Hello "; // binding scope
void checkHello()
{    
    System.out.println(hello);
}
checkHello();

println "---------"

// -----------------------> Equality in Groovy using ==, equals(), is() <--------------------

// Groovy treats == as the equivalent of the equals() method in Java
// If you want to check for actual object identity equality, you need to use Groovy’s builtin is() function

Integer x = new Integer(2)
Integer y = new Integer(2)
Integer z = null

if (x == y)
{
    println "x == y"
}
if (x.equals(y))
{
    println "x is equals to y"
}
if (!x.is(y))
{
    println "x is not y"
}
if (z.is(null))
{
    println "z is null"
}
if (z == null)
{
    println "z is null"
}

println "---------"

// -----------------------> Groovy Bean, The safe-dereference operator (?.), The Elvis operator (?:) <--------------------

// ---- GroovyBeans are much like JavaBeans, except they omit the explicit getters and setters, provide auto constructors, and allow you to reference member variables using dot (.) notation
// You can use the @Immutable annotation to make a GroovyBean immutable (meaning its state can’t change). This can be useful for passing around thread-safe data constructs, which is much safer for use with concurrent code.

class Character
{
    private int strength
    private int wisdom
}

def pc = new Character(strength: 10, wisdom: 15)
println "STR [" + pc.strength + "] WIS [" + pc.wisdom + "]"
pc.strength = 18
println "STR [" + pc.strength + "] WIS [" + pc.wisdom + "]"

// ---- By using safe-dereference operator (?.) notation, Groovy introduces a special null construct that effectively represents “do nothing” as opposed to an actual null reference

println pc?.strength

pc = null    // --- Make it null

if(pc!=null)
    println pc.strength  // --- This is Java development style of avoiding java.lang.NullPointerException

println pc?.strength // --- This is Groovy way of using safe-dereference operator of avoiding java.lang.NullPointerException 

// ---- The Elvis operator (?:) allows you to write if/else constructs that have a default value in extremely short syntax

String agentStatus = "Active"
println (agentStatus ? agentStatus : "Inactive") // --- Java development style
println agentStatus ?: "Inactive"  // --- Groovy way of using Elvis operator

// The Elvis operator allows you to omit the explicit null check as well as avoiding any repetition of variables

agentStatus = null
println (agentStatus ? agentStatus : "Inactive") // --- Java development style
println agentStatus ?: "Inactive"  // --- Groovy way of using Elvis operator

println "---------"