package com.example.codepractice

open class Person(name: String, age: Int) : Work(), Game {
    open fun work() {
        println("Trabajando")
    }

    override fun goToWork() {
        println("Va al trabajo")
    }

    // Game interface
    override val game: String
        get() = "Among us"

    override fun play() {
        println("Persona jugando $game")
    }
}