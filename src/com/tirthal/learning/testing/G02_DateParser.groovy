package com.tirthal.learning.testing

@Grapes(
    @Grab(group='joda-time', module='joda-time', version='2.3')	
)
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

class G02_DateParser {
    def String parse(time) {
        // !null is equal to "true" in Groovy
        if(!time)                                        // alternative condition to check if time is null --- time == null
            throw new IllegalArgumentException()
    
        def printableTime = new DateTime(time)
        def format = DateTimeFormat.forPattern('dd/MM/yyyy - hh:mm aa')
                
        return printableTime.toString(format)
    }
}