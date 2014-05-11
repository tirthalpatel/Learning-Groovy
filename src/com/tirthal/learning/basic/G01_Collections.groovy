package com.tirthal.learning.basic

// =========== RUN SCRIPT FILE USING GROOVY SHELL OR GROOVY CONSOLE ================

// ----------------------> Collections Syntax <--------------------

println "---- Creating List and printing it -----"

jvmLanguages = ["Java", "Groovy", "Scala", "Clojure", 12345]; // Mixed types are allowed while creating list
println(jvmLanguages[0]); // output =  Java
println(jvmLanguages.size()); // output = 5
println(jvmLanguages); // output = [Java, Groovy, Scala, Clojure, 12345]

jvmLanguages = [];
println(jvmLanguages);

println "---- Iterating List -----"

def cities = ["Ahmedabad", "Pune", "Bangalore"] // dynamic variable declaration to define arrays

println "List of cities are - $cities & current time is - ${new Date()}" // Another Strings and GString example

for(int i=0; i < cities.size() ; i++) { // option 1 - iterate arrays collection using for loop
    def greeting = "Welcome to "
    println "$greeting" + cities[i]
    // println "$greeting" + "${cities[i]}"
}

for (city in cities) { // option 2 - iterate collection using for each
    println "Welcome to $city"
}

println "----- Creating Map and printing it ----"

languageRatings = [Java:100, Groovy:99, Clojure:"N/A"]; // Creating Map
println(languageRatings["Java"]);
println(languageRatings.Clojure);

languageRatings["Clojure"] = 75; // Changing value for "Clojure' key
println(languageRatings["Clojure"]);

println languageRatings; // output = [Java:100, Groovy:99, Clojure:75]

languageRatings = [:]; // Make it empty
println languageRatings; // output = [:]