package com.tirthal.learning.testing

/**
 * Exchange Rate Service class, which is used in G03_ExchangeRateCityBank to demo mocking of external service
 * 
 * @author tirthalp
 *
 */
class G03_ExchangeRateGlobalService {
    
    // Retrieve exchange rate for USD to INR currency
    def double getUsdtoInrExchangeRate() {
    
        // ---- Logic to get today's exchange rate from external global web service
        
        // For now returing hard-coded 0.0, but in reality it should return the current exchange rate 
        return 0.0;
    }
}