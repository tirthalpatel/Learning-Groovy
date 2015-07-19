package com.tirthal.learning.java2groovy

println "How Java 5 features work in Groovy e.g. autoboxing, for-each, enum..."

// --- Autoboxing
int val = 10 // Even specified as int, Groovy simply treats them as object (java.lang.Integer) instead of constant casting
println val.getClass().name

// --- For-each
String[] greetings = ["Hello" , "Hi" , "Howdy"]
for(greet in greetings) // can use the in keyword instead of a colon (:)
{
	println greet
}

// --- Enum
enum CoffeeSize { SHORT, SMALL, MEDIUM, LARGE, MUG }

def orderCoffee(size)
{
	print "Coffee order received for size $size: "
	switch(size)
	{
		case [
			CoffeeSize.SHORT,
			CoffeeSize.SMALL
		]:
			println "you're health conscious"
			break
		case CoffeeSize.MEDIUM..CoffeeSize.LARGE:
			println "you gotta be a programmer"
			break
		case CoffeeSize.MUG:
			println "you should try Caffeine IV"
			break
	}
}

orderCoffee(CoffeeSize.SMALL);
orderCoffee(CoffeeSize.LARGE);
orderCoffee(CoffeeSize.MUG);

print 'Available sizes are: '
for(size in CoffeeSize.values())
{
	print "$size "
}

// --- Varargs
def foo1(int a, int... b) // Java way of varargs using ...
{
	println "You passed $a and $b"
}
def foo2(int a, int[] b) // Groovy way of passing an array as trailing parameters
{
	println "You passed $a and $b"
}
foo1(1, 2, 3, 4, 5)
foo2(1, 2, 3, 4, 5)

// --- Static imports : To define an alias, use the as operator in the import statement
import static Math.random as rand
import groovy.lang.ExpandoMetaClass as EMC

double value = rand()
def metaClass = new EMC(Integer)
assert metaClass.getClass().name == 'groovy.lang.ExpandoMetaClass'

// --- Generics
/*
 * Groovy is a dynamic language; however, it is optionally typed and supports Generics. 
 * The Groovy compiler does not perform type checks like the Java compiler does (No Compile-Time Type Checking). 
 * So, code with type violations that’ll be rejected by the Java compiler are quietly accepted by the Groovy compiler. 
 * However, Groovy’s dynamic typing will interplay here to get your code running, if possible.
 */
ArrayList<Integer> lst = new ArrayList<Integer>();
lst.add(1);
lst.add(2);
lst.add("hello");	// Java compiler would reject this, but Groovy does not
lst.add(4);
lst.add(5);

total = 0;
for(i in lst)
{
	System.out.println(i);
	total += i;				// Java compiler would reject this, but Groovy does not
}

System.out.println("Total is " + total);

try
{
	for(i in lst)
	{
		System.out.println(i.intValue()); // here it would break, when tries to apply intValue() on String
	}
}
catch(Exception ex)
{
	System.out.println(ex);
}
