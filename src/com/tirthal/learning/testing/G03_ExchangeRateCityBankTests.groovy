package com.tirthal.learning.testing

import groovy.util.GroovyTestCase // Wrapper class exists in Groovy API that wraps underline JUnit APIs
import groovy.mock.interceptor.*

// ----------------------- Run the test

class G03_ExchangeRateCityBankTests extends GroovyTestCase {

    def void testOfferedUsdToInrRatesUsingStubFor() {
        
        def cityBankRates = new G03_ExchangeRateCityBank()     
        
        // offeredUsdToInrRates --- This call the ExchangeRateGlobalService which is expected to return different rates daily basis
        
        // Hence we need to mock ExchangeRateGlobalService for unit testing of offeredUsdToInrRates()
        
        // --- Create the stub of ExchangeRateGlobalService service using "StubFor", which will not test interaction between ExchangeRateCityBank and ExchangeRateGlobalService
        def service = new StubFor(G03_ExchangeRateGlobalService) 
        service.demand.getUsdtoInrExchangeRate {             // --- demand closure will give ability to override any method of the service
            return 55.0
        }
        service.use {                                        // --- use closure will tell that inside the context of closure use the overrided stub methods     
            assert 56 == cityBankRates.offeredUsdToInrRates()
        }
    }
    
     def void testOfferedUsdToInrRatesUsingMockFor() {
        
        def cityBankRates = new G03_ExchangeRateCityBank()     
        
        // offeredUsdToInrRates --- This call the ExchangeRateGlobalService which is expected to return different rates daily basis
        
        // Hence we need to mock ExchangeRateGlobalService for unit testing of offeredUsdToInrRates()
        
        // --- Create the mock of ExchangeRateGlobalService service using "MockFor", which will test interaction between ExchangeRateCityBank and ExchangeRateGlobalService too
        def service = new MockFor(G03_ExchangeRateGlobalService) 
        service.demand.getUsdtoInrExchangeRate {             // --- demand closure will give ability to override any method of the service
            return 55.0
        }
        service.use {                                        // --- use closure will tell that inside the context of closure use the overrided stub methods     
            assert 56 == cityBankRates.offeredUsdToInrRates()
        }
    }
}