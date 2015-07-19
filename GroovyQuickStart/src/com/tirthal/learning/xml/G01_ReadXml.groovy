package com.tirthal.learning.xml

// =========== RUN SCRIPT FILE USING GROOVY SHELL OR GROOVY CONSOLE ================ 

// ----------------------> Reading XML file <-------------------- 

// --- Simple code of reading XML

// Build XML as Groovy style code
class XmlExample {
static def PERSON =
    """
    <person id='2'>
	    <name>Gweneth</name>
	    <age>1</age>
    </person>
    """
}

// Person definition in Groovy
class Person {def id; def name; def age}

// Read in XML using XMLParser, which supports GPath expressions for XML documents
def xmlPerson = new XmlParser().parseText(XmlExample.PERSON)
// Populate Person GroovyBean
Person p = new Person(id: xmlPerson.@id, name: xmlPerson.name.text(), age: xmlPerson.age.text()) // @ is used for accessing attribute 
println "${p.id}, ${p.name}, ${p.age}"

println "----------"

// --- Read XML from file

// Setup file path

def filePath = 'data/catalog.xml'

// Declare file and check it exists!

def xmlFile = new File(filePath)

println "Is file exists? " + xmlFile.exists()

// Read xml using Groovy's XmlSlurper parsing API

def slurper = new XmlSlurper()
def xData = slurper.parse(xmlFile)

// println xData // Use this to print all data

// Print some portions of xml data

println "Name element = " + xData.name
println "Author element = " + xData."author-full-name"  // if xml tag contains dashes, then just wrap the dashed tag names in quotes and Groovy will compensate accordingly
println "Email element = " + xData.email

println "Library attribute of Books element = " + xData.books.@library

println xData.something.not.exist // If something doesn't exist in xml specification, it will not give any error

println "Printing books id, title, price -----------"
 xData.books.book.each({
     println "Book Id - " + it.@id + ", Title - " + it.title + ", Price - " + it.price
 })
 
 println ""
 
 // Groovy extension methods - dump, inspect, with
 
println "Beginning dump....." + xData.name.value.dump()
println ""

println "Beginning inspect....." + xData.name.inspect()
println ""

xData.with {
    println "Name element = " + name
    println "Email element = " + email    
}