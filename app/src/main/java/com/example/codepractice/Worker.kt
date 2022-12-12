package com.example.codepractice

data class Worker(val name: String = "", val age: Int = 18, val work: String = "") {
    // Propiedad que represente el anterior trabajo
    var lastWork: String = ""
}
