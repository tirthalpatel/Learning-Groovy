package com.tirthal.learning.basic

// =========== RUN SCRIPT FILE USING GROOVY SHELL OR GROOVY CONSOLE ================

// ----------------------> Using List <--------------------

println "---- Creating List and printing it -----"

jvmLanguages = ["Java", "Groovy", "Scala", "Clojure", 12345]; // Mixed types are allowed while creating list
println(jvmLanguages.getClass().name) // output = java.util.ArrayList
println(jvmLanguages[0]); // output =  Java
println(jvmLanguages[-1]); // output using negative index = 12345
println(jvmLanguages.size()); // output = 5
println(jvmLanguages); // output = [Java, Groovy, Scala, Clojure, 12345]
println(jvmLanguages[2..4]); // output using range = [Scala, Clojure, 12345]

println jvmLanguages.dump()

jvmLanguages = [];
println(jvmLanguages);

println "---- Iterating List -----"

def cities = ["Ahmedabad", "Pune", "Bangalore"] // dynamic variable declaration to define arrays

for(int i=0; i < cities.size() ; i++) { // option 1 - iterate arrays collection using for loop
    def greeting = "Welcome to "
    println "$greeting" + cities[i]
    // println "$greeting" + "${cities[i]}"
}

for (city in cities) { // option 2 - using optimized for loop
    println "Welcome to $city"
}

cities.each { // option 3 - list's each method
	println "Welcome to $it"
}

println "---- List’s other methods -----"

println "List's collect method: " + cities.collect { it + '-India'} // operate something on each element in a collection and return a resulting collection
println "List's finder method: " + cities.find { it.equals('Ahmedabad') }
println "List's sum method: " + cities.collect { it.size() }.sum()
println "List's join method: " + cities.join(' --- ') // concatenate the elements of the collection using '---' separator
println "List's reverse method: " + cities.reverse()
println "List's minus (-) operator : " + (cities - ['Pune'])

// ----------------------> Using Map <--------------------

println "----- Creating Map and printing it ----"

languageRatings = [Java:100, Groovy:99, Clojure:'N/A']; // Creating Map
println(languageRatings.getClass().name) // output = java.util.LinkedHashMap
println(languageRatings["Java"]); // output = 100
println(languageRatings.Clojure); // output = N/A

languageRatings["Clojure"] = 75; // Changing value for "Clojure' key
assert languageRatings["Clojure"] == 75

println languageRatings; // output = [Java:100, Groovy:99, Clojure:75]

println "---- Iterating Languages -----"

languageRatings.each { entry ->		// option-1
	println "Language $entry.key is rated to $entry.value"
}

languageRatings.each { language, rating ->	// option-2
	println "Language $language is rated to $rating"
}

println "---- Map's other methods -----"

println "Looking for all languages with name rating than 90 characters"
selected = languageRatings.findAll { language, rating ->	// findAll method
	rating > 90
}
selected.each { key, value ->
	println "Found $key with $value rating"
}

languageRatings = [:]; // Make it empty
println languageRatings; // output = [:]