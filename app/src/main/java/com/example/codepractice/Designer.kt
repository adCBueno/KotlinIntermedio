package com.example.codepractice

class Designer(name: String, age: Int): Person(name, age) {
    override fun work() {
        println("Disigning")
    }
}