package com.example.codepractice

class Programmer(name: String, age: Int, val language: String): Person(name, age), Vehicle {
    override fun work() {
        println("Programando")
    }

    fun sayLanguage() {
        println(language)
    }

    override fun goToWork() {
        println("Va a Google")
    }

    override fun drive() {
        println("Conduce")
    }
}