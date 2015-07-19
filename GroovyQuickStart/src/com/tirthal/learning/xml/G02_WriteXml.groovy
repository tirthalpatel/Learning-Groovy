package com.tirthal.learning.xml

// =========== RUN SCRIPT FILE USING GROOVY SHELL OR GROOVY CONSOLE ================ 

// ----------------------> Write XML file <-------------------- 

// --- Simple code to write and print xml
def writer = new StringWriter()
def x = new groovy.xml.MarkupBuilder(writer)
x.person(id:2) {
    name 'Gweneth'
    age 1
}
println writer.toString()

println "------"

// --- Create XML file

// Setup file path

def filePath = 'data/articles.xml'

// Create XML content using Groovy's MarkupBuilder

def builder = new groovy.xml.StreamingMarkupBuilder()

def xml = builder.bind {
    ArticleSet {
      mkp.comment("This contains list of articles") // Adding comment
      
      Article {
        Journal (id: 1) {                           // Adding <Journal> element with "id = 1" attribute
          Volume(2)
          Issue("Tokzo Series")
        }
      }
      
       Article {
        Journal (id: 2) {
          Volume(4)
          Issue("Zomie Tickie")
        }
      }
    }
}

// Write XML to the file

def outFile = new File(filePath)
outFile.write("<?xml version='1.0'?>" + xml.toString())
