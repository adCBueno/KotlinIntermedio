package com.example.codepractice

class MyNestedAndInnerClass {

    private val one = 1

    private fun returnOne() : Int {
        return one
    }

    // Clase anidada
    class MyNestedClass {
        fun sum(first: Int, second: Int): Int {
            return first+second
        }
    }

    // Clase interna puede acceder a variables de su clase superior
    inner class MyInnerClass {
        fun sumTwo(number: Int) : Int {
            return number+one+returnOne()
        }
    }
}