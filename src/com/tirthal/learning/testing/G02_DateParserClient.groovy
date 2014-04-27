package com.tirthal.learning.testing;

def parser = new G02_DateParser()
println parser.parse(new Date())

println parser.parse(null)