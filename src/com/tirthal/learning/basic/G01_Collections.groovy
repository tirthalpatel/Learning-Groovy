package com.tirthal.learning.basic

// =========== RUN SCRIPT FILE USING GROOVY SHELL OR GROOVY CONSOLE ================

// ----------------------> Collections Syntax <--------------------

println "---- List -----"

jvmLanguages = ["Java", "Groovy", "Scala", "Clojure", 12345]; // Mixed types are allowed in list
println(jvmLanguages[0]);
println(jvmLanguages.size());
println(jvmLanguages);
jvmLanguages = [];
println(jvmLanguages);

println "---- Iterating List -----"

def cities = ["Ahmedabad", "Pune", "Bangalore"] // dynamic variable declaration to define arrays

println "10 + 10 is equal to ${10+10}" // GString ${expression} example
println "List of cities are - $cities & current time is - ${new Date()}" // Another Strings and GString example

for(int i=0; i < cities.size() ; i++) { // option 1 - iterate arrays collection using for loop
    def greeting = "Welcome to "
    println "$greeting" + cities[i]
    // println "$greeting" + "${cities[i]}"
}

for (city in cities) { // option 2 - iterate collection using for each
    println "Welcome to $city"
}

println "----- Map ----"

languageRatings = [Java:100, Groovy:99, Clojure:"N/A"]; // Map
println(languageRatings["Java"]);
println(languageRatings.Clojure);
languageRatings["Clojure"] = 75;
println(languageRatings["Clojure"]);
languageRatings = [:];
println languageRatings;