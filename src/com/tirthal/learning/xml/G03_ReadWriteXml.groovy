package com.tirthal.learning.xml

// =========== RUN SCRIPT FILE USING GROOVY SHELL OR GROOVY CONSOLE ================ 

// ----------------------> Reading and Writing XML file <-------------------- 

// Setup file paths

def inFilePath = 'data/catalog.xml'
def outFilePath = 'data/books.xml'

// Task = read "catalog.xml" and write new "books.xml" file with some manipulations

// Read xml using Groovy's XmlSlurper parsing API

def xmlInFile = new File(inFilePath)
println "Is file exists? " + xmlInFile.exists()

def slurper = new XmlSlurper()
def xData = slurper.parse(xmlInFile)

// Create XML content using Groovy's MarkupBuilder

def builder = new groovy.xml.StreamingMarkupBuilder()

def xmlOut = builder.bind {
    
    mkp.comment(xData.books.@library)                   // Adding comment. The value of <books> element's "library" attribute of catalog.xml is assigned here.
    
    library {                                            // Adding new <library> element
        xData.books.book.each { b ->            
            book(title : b.title.toString()) {           // Adding <book> element having "title" attribute. The value is assigned from <title> element of catalog.xml
                id (b.@id)                               // Adding <id> element. The value is assigned from "id" attribute of <book> element of catalog.xml
                author(b.author.toString())              // Adding <author> element. The value is assigned from <author> element of catalog.xml
                price(b.price.toString())                // Adding <price> element. The value is assigned from <price> element of catalog.xml
                description(b.description.toString())    // Adding <description> element. The value is assigned from <description> element of catalog.xml
            }
        }
    }
}

// Write XML to the file

def outFile = new File(outFilePath)
outFile.write("<?xml version='1.0'?>" + xmlOut.toString())