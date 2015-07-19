package com.tirthal.learning.java2groovy

// In Groovy you can make method and constructor parameters optional.
// In fact, make as many parameters optional as you like, but they have to be trailing. 
// To define an optional parameter, you simply give it a value in the parameter list.
def favColor(name, color="red") {
	println "$name's favorite color: $color"
}

favColor("Tids")
favColor("Sid", "white")

// Groovy also treats the trailing array parameter as optional. 
// So you can send zero or more values for the last parameter.
def todo(name, String[] details) {
	println "$name - $details"
}

todo 'Call' , 'Mr. Bob'
todo 'Call' , '123-456-7890' , '0987-654-321'
todo 'Check Emails'