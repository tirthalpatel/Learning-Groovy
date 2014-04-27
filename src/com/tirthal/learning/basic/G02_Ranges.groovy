package com.tirthal.learning.basic

// =========== RUN SCRIPT FILE USING GROOVY SHELL OR GROOVY CONSOLE ================

// ----------------------> Ranges Syntax <--------------------

// ----- Example 1 - Numbers and Alphabet ranges

print "Numbers range = "
def numbers = 1..10 // declaring numbers range from 1 to 10
for (number in numbers)
    print "$number ";
println ""

print "Alphabet letters range = "
def alphabets = 'a'..'z' // declaring alphabet letters range from a to z
for (letter in alphabets)
    print "$letter ";
println ""

// ---- Example 2 - Custom range - How to define range of weekdays and weekend using Enum?
def enum DAYS {
    SUN, MON, TUE, WED, THU, FRI, SAT
}
println "Saturday = ${DAYS.SAT} and Sunday = ${DAYS.SUN}"

def weekdays = DAYS.MON..DAYS.FRI // Weekdays range
print "Week days are -"
for (weekday in weekdays) {
    print "$weekday "
}

println ""

println "Extents: start of weekday is " + weekdays.from + " and end of weekday is " + weekdays.to   // Starting and Ending point of range