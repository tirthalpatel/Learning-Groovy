package com.tirthal.learning.java2groovy

// --------------------------------------
// Java way --- person POJO / Bean class
// --------------------------------------
class PersonJavaBeanDemo {

	private String name;
	private int age;

	public PersonJavaBeanDemo(String name) {
		this.name = name;
	}

	// Develop needs to write getter/setter methods
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}

// Try it
PersonJavaBeanDemo pj = new PersonJavaBeanDemo("Tids");
pj.setAge(33);
System.out.println("Java way --- Name:" + pj.getName() + " , Age:" + pj.getAge());

// --------------------------------------
// Groovy way - to rewrite above code (Groovy doesn't ask you to create getter/setter)
// --------------------------------------
class PersonGroovyBeanDemo {

	// final = read only property, can change the property from within instance methods of the defining class, but not from outside.
	// Groovy provides a getter in this case and no setter
	final name;
	// def = declare property in the context of this class
	// Groovy quietly creates a getter and setter method for you behind the scenes
	def age;

	PersonGroovyBeanDemo(theName) {
		name = theName
	}
}

// Try it
PersonGroovyBeanDemo pg = new PersonGroovyBeanDemo("Tids");
pg.age = 33	// Internally calling setter method of age property
println "Groovy way --- Name: $pg.name , Age: $pg.age"	// Internally calling getter methods

try {
	pg.name = "Can I update read-only property?" // Answer = No, you will get exception
} catch(groovy.lang.ReadOnlyPropertyException ex) {
	println ex.message
}

