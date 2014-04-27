package com.tirthal.learning.testing


// ----------------------- Run the test

class G01_CalculatorTests extends GroovyTestCase {

    private calc
    
    def void setUp() {
        println "In setup"
        calc = new G01_Calculator()
    }

    def void tearDown() {
        println "In teardown"
        calc = null
        println "-----"
    }
    
    // In Groovy, all test methods must be prefixed with "test". Otherwise won't be considered as unit test methods.
    def void extraMethodTest() {
        println "This is not eligible to execute as unit test"
    }
    
    def void testAddNumbers() {
        println "In test add numbers"
        calc.add(10,20)
        assert 30 == calc.result // Though result is of private type, but Groovy automatically generates accessors for private too and internally calls getters 
        //assert 35 == calc.result // Uncomment this to see error 
    }

     def void testMultiplyNumbers() {
        println "In test multiply numbers"
        calc.multiply(10,20)
        assert 200 == calc.result // Though result is of private type, but Groovy automatically generates accessors for private too and internally calls getters 
        //assert 35 == calc.result // Uncomment this to see error 
    }
    
    def void testCanNotAddNegativeNumbers() {
        println "In test numbers must be positive to add"
        shouldFail(G01_CalculatorNegativeUnsupportedException) { // Only CalculatorNegativeUnsupportedException type of exception is valid/acceptable, otherwise fail the test case
             calc.add(10, -10) // Replace -10 with 10 to see error             
        }
    }
    
     def void testCanNotMultiplyNegativeNumbers() {
        println "In test numbers must be positive to multiply"
        shouldFail(G01_CalculatorNegativeUnsupportedException) { // Only CalculatorNegativeUnsupportedException type of exception is valid/acceptable, otherwise fail the test case
             calc.add(10, -20) // Replace -20 with 20 to see error                   
        }
    }
   
}