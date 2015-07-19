package com.tirthal.learning.testing

/**
 * City Bank Exchange Rate class for mock testing demo
 * 
 * @author tirthalp
 *
 */
class G03_ExchangeRateCityBank {
    
    def offeredUsdToInrRates() {
    
        // Exchange rate recieved from global service
        def service = new G03_ExchangeRateGlobalService()            

        // Replace service.getUsdtoInrExchangeRate() with hardcoded value "55" and run the test, then stub will pass it but mock will fail. 
        // Because mock also checks for the interaction of the overided method 
        def globalRate = service.getUsdtoInrExchangeRate()                

        // Bank's service charges        
        def cityBankCharges = 1                             
        
        def offeredUsdToInrRates = globalRate + cityBankCharges
    }

}