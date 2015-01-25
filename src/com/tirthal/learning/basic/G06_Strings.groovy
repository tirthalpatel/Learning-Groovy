package com.tirthal.learning.basic

// =========== RUN SCRIPT FILE USING GROOVY SHELL OR GROOVY CONSOLE ================

// ------> Literals and Expressions <------

// In Java, ’a’ is a char, while "a" is a String. 
// Groovy makes no such distinction; both of these are instances of String in Groovy. Because there are no primitives in Groovy.
println 'My name is - "Tirthal Patel"'

str = 'This is a string'
println str.getClass().name	// instances of String

// If you put any expressions in single quotes, Groovy won’t expand them. Use double quotes for expressions to work.
value = 25
println 'The value is ${value}' 
println "The value is ${value}"

// Java Strings are immutable, and Groovy honors that immutability
str = 'hello'
println str[2]	 // can read a character using [ ] operator
try
{
	str[2] = '!' // Once you create an instance of String, you can’t modify its content by calling setters, and so on
}
catch(Exception ex)
{
	println ex
}

println '---------'

// Groovy uses lazy evaluation - You can store an expression in a string and print it later
who = new StringBuffer('Tirthal' )
text = "I am $who"
println text
who.replace(0, 7, "Patel" )
println text

println '---------'

// ------> GString - known as Groovy String <------

// Strings created using single quotes are regular java.lang.Strings. However, those created using double quotes and slashes are special "GString".
val = 125
printClassInfo ("The Stock closed at ${val}")
printClassInfo (/The Stock closed at ${val}/)
printClassInfo ('This is a simple String ${val}')
def printClassInfo(obj)
{
	println "class: ${obj.getClass().name}"
	println "superclass: ${obj.getClass().superclass.name}"
}

// Using closure in GString
quote = "Today ${-> company } stock closed at ${-> price }"

stocks = [Apple : 130.01, Microsoft : 35.95]
stocks.each { key, value ->
	company = key
	price = value
	println quote
}

println '---------'

// ------> Multiline String <------

// In Java - using the + operator, or multiple calls to the append() method of StringBuffer or StringBuilder
// In Groovy - define a multiline literal by enclosing the string within three single quotes ('''...''') / double quotes ("""...""")

question = 'What Is Software Architecture?'

answer = """$question

The software architecture of a program or computing system is a depiction of the system 
that aids in the understanding of how the system will behave."""

println answer

println '---------'

// ------> String Convenience Methods <------

// Groovy adds other convenience methods to String: plus( ) [+], multiply( ) [*], next( ) [++], replaceAll( ), and tokenize( ), to mention a few.
str = "It's a gloomy day in Ahmedabad"
println str
str -= "gloomy " // -= operator removes part of the string that matches the string on the right side
println str

// Iterate over a range of Strings - 00a, 00b,... 00z
for(str in '00a'..'00z' )
{
	print "${str} "
}
println ""