package com.tirthal.learning.basic

import java.util.regex.Pattern
import java.util.regex.Matcher

// =========== RUN SCRIPT FILE USING GROOVY SHELL OR GROOVY CONSOLE ================

// ----------------------> Regular Expression <--------------------

// Groovy treats regular expressions as a built-in part of the language, making activities such as text processing much simpler than in Java
    // ~ Creates a pattern (creates a compiled Java Pattern object)
    // =~ Creates a matcher (creates a Java Matcher object)
    // ==~ Evaluates the string (effectively calls Java’s match() on the Pattern)
    

// --- Example 1- Say you want to partially match on some incorrect log data that you’ve received from a piece of hardware. 
// In particular, you’re looking for instances of the pattern 1010, which you’re then looking to flip around to 0101

// Java style

Pattern pattern = Pattern.compile("1010");
String input = "1010";
Matcher matcher = pattern.matcher(input);
if (input.matches("1010")) {
    input = matcher.replaceFirst("0101");
    System.out.println(input);
}

// In Groovy, the individual lines of code are shorter, because the Pattern and Matcher objects are built into the language

def gPattern = /1010/
def gInput = "1010"
def gMatcher = gInput =~ gPattern
if (gInput ==~ gPattern)
{
    gInput = gMatcher.replaceFirst("0101")
    println gInput
}

println "-----------"

// --- Example 2 - print out the details of a person by parsing a String and pulling out the name and age

("Tirthal 32" =~ /(\w+) (\d+)/).each {full, name, age -> println "$name is $age years old."}

println "-----------"