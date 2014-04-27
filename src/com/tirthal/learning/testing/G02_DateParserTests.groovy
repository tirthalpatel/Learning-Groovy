package com.tirthal.learning.testing

@Grapes(
    @Grab(group='joda-time', module='joda-time', version='2.3')
)
import org.joda.time.DateTime

import groovy.util.GroovyTestCase

// ----------------------- Run the test

class G02_DateParserTests extends GroovyTestCase {

    private G02_DateParser parser
    
    def void setUp() {
        parser = new G02_DateParser()
    }
     
    def void testCanParseDateTime() {
        def dateTime = new DateTime(2014,1,10,14,30)
        def result = parser.parse(dateTime.toString())
        
        assert '10/01/2014 - 02:30 PM' == result
    }

    // negative test
    def void testWillThrowAnErrorWhenNullDateTimeIsProvided() {       
        shouldFail(IllegalArgumentException) {                    // Test should fail with IllegalArgumentException, if null value is supplied
            parser.parse(null)
        }
    }
}