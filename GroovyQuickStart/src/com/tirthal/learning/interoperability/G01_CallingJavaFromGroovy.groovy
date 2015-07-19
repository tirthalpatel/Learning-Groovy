package com.tirthal.learning.interoperability

// =========== RUN SCRIPT FILE USING GROOVY SHELL OR GROOVY CONSOLE ================ 

// ----------------------> Calling Java libraries in Groovy & Dependency Management using Groovy's natively supported "Grape" <-------------------- 

// For example - how to use Joda's DateTime for formating in Groovy

// Step 1 - Search "Joda" in Maven Repository (e.g. http://www.mvnrepository.com/) and you would find below from "Grape" section
// When you run this groovy script, it would cache this libraries for future use (e.g. in windows at this location - C:\Users\<user>\.groovy\grapes)

@Grapes(
    @Grab(group='joda-time', module='joda-time', version='2.3')
)

// Step 2 - Import java APIs
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

// Step 3 - Print current date time without formatting

def date = new Date()

println "$date"

// Step 4 - Option 1 - Use Joda's java APIs for formatting in Groovy

println new DateTime(date) // default format of Joda DateTime

def format = DateTimeFormat.forPattern('MM/dd/yyyy - hh:mm:ss') // Set the formatting patter

println new DateTime(date).toString(format) // Apply the formatting pattern

// Step 4 - Option 2 - Adding functionalities with Categories (Categories allow you to easily add custom logic to existing classes)

class DateTimeCategory {
    def static String createPrintableTime(dateTime, suffix) {    
        def format = DateTimeFormat.forPattern('MM/dd/yyyy - hh:mm aa')
        return dateTime.toString(format) + " - " + suffix  
    }
}

use(DateTimeCategory) {
    println new DateTime(date).createPrintableTime('testing suffix added')
}