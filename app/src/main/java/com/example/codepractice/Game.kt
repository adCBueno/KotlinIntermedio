package com.example.codepractice

interface Game {
    val game: String

    fun play() // Por defecto estas funciones son abstractas

    fun stream() {
        println("Stream de ${game}")
    }
}