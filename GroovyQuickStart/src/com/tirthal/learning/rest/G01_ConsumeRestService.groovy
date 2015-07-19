package com.tirthal.learning.rest

@Grapes([
    @Grab(
        group='org.codehaus.groovy.modules.http-builder', 
        module='http-builder', 
        version='0.6')
    ])

import groovyx.net.http.RESTClient

// Consuming a public REST API for searching geolocation of IP addresses and host names - https://www.freegeoip.net/{format}/{ip_or_hostname}
// Demo URL = http://freegeoip.net/json/www.tirthalpatel.blogspot.com


def configFilePath = "src/com/tirthal/learning/rest/G01_Config.groovy"

// --- Step 1 - Use Groovy's ConfigSlurper to read configuration values

def configFile = new File(configFilePath)
def configSlurper = new ConfigSlurper()
def configuration = configSlurper.parse(configFile.toURL())

println "REST URL = " + configuration.geoip.rest.url    // Reading property from configuraiton file

// --- Step 2 = Configure rest service and call it

def geolocationApi = new RESTClient("${configuration.geoip.rest.url}")        // configure rest service url

def hostnameString = {hostname -> "/json/$hostname"}  // configure query string parameters using Groovy's closure 

// --- Step 3 = Call service

def response = geolocationApi.get(path: hostnameString.call("www.tirthalpatel.blogspot.com"))    // call service using get()

// --- Step 4 = Check response status and data

println "REST Webservice Response Status = " + response.status // What is status? --- 200 = OK / groovyx.net.http.HttpResponseException: Not Found.
println "Geo location data from REST WS Response = " + response.data

// --- Step 5 = Parsing JSON data

println "-----"

response.data.with {
    println "IP = " + ip
    println "Region Name = " + region_name
    println "City = " + city
    println "Country Name" + country_name
}