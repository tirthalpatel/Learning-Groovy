Groovy learning made easy
=========================

Sample code snippet for getting started with Groovy. 


Groovy Setup - installation
---------------------------
* GVM - Groovy enVironment Manager for unix based system
* For Windows - http://groovy.codehaus.org/Installing+Groovy

* Available options to run Groovy script?
	- groovysh - Groovy shell to test different groovy expressions without need of IDE
	- groovyConsole - Swing interactive UI to test Groovy statements
	- groovyc  xyz.groovy - groovyc to compile groovy script
	- groovy xyz - to compile and run the groovy script file
	- Run using Eclipse IDE - Install Groovy plugin http://groovy.codehaus.org/Eclipse+Plugin


Setup instructions for this "GroovyQuickStart" project
------------------------------------------------------
(1) Download / Clone this project to your local machine

(2) Just import project in Eclipse having Groovy plugins already installed. 

(3) Fix build path errors (Project -> Properties -> Java Build Path -> Libraries), such as JRE configuration, Groovy Libraries, etc. 

(4) That's it. Now run groovy script files with Groovy Script option (Alt + Shift + X, G) and start exploring code of "*.groovy" files in given sequence of G00*, G01*, G02*...


Basic Concepts and Syntax
-------------------------
[Learn by code snippet] (https://github.com/tirthalpatel/Learning-Groovy/tree/master/src/com/tirthal/learning/basic)


Working with XML
----------------
[Learn by code snippet] (https://github.com/tirthalpatel/Learning-Groovy/tree/master/src/com/tirthal/learning/xml)


Interoperability between Groovy and Java
-----------------------------------------
[Learn by code snippet] (https://github.com/tirthalpatel/Learning-Groovy/tree/master/src/com/tirthal/learning/interoperability)


Unit testing in Groovy
----------------------
[Learn by code snippet] (https://github.com/tirthalpatel/Learning-Groovy/tree/master/src/com/tirthal/learning/testing)


Working with REST services
-------------------------
[Learn by code snippet] (https://github.com/tirthalpatel/Learning-Groovy/tree/master/src/com/tirthal/learning/rest)


Working with Databases using Groovy
-------------------------------------
* Import MySQL libraries
	- @GrabConfig(systemClassLoader=true)
	- @Grab('mysql:mysql-connector-java:5.1.6')
	- import groovy.sql.Sql

* Database connection
	- def sql = Sql.newInstance("jdbc:mysql://localhost:3306/dbname", "username", "password", "com.mysql.jdbc.Driver")

* Store data
	- def table = sql.dataSet("tablename")
	- table.add(x: 123, y: "abc")

* Read and update data
	- sql.eachRow('select * from table') { 	Println "X: ${it.x}, Y: ${it.y}"  }
	- sql.executeUpdate("update table set x = 444")

* Close connection
	- sql.close()
		
		
What’s new in Groovy 2.0?
-------------------------
	The newly released Groovy 2.0 brings key static features to the language with static type checking and static compilation, 
	adopts JDK 7 related improvements with Project Coin syntax enhancements and the support of the new "invoke dynamic" JVM instruction, 
	and becomes more modular than before. 
	
[Read further...] (http://www.infoq.com/articles/new-groovy-20)


Groovy 2.3 - Finale released in May 2014
-----------------------------------------

* Feature set
	- official support for running Groovy on JDK 8
	- traits, as a new object oriented way of composing behavior in your classes
	- new and improved AST transformations like @TailRecursive, @Builder and @Sortable
	- a new NIO2 module with Path support
	- lightening fast JSON parsing and building
	- closure parameter type inference
	- a new markup template engine
	- Groovysh and GroovyConsole ease of use improvements
	- a new GroovyAssert test utility
	- more @BaseScript class capabilities, and more.

* Introduces Traits - A trait is a reusable set of methods and fields that can be added to one or more classes. A class can be composed out of multiple traits without using multiple inheritance (and therefore avoiding the diamond problem). [Read further...] (http://java.dzone.com/articles/groovy-23-introduces-traits)


Groovy Roadmap
---------------

[Stay tuned to Groovy releases roadmap...] (http://groovy.codehaus.org/Roadmap)