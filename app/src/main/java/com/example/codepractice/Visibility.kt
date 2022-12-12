package com.example.codepractice

private class Visibility {
    var name: String? = null
    fun sayMyName() {
        name?.let {
            println("Mi nombre es $it")
        } ?: run {
            println("No tengo nombre")
        }
    }
}

open class VisibilityTwo {
    protected fun sayMyNameTwo() {
        val visibility = Visibility()
        visibility.name = "Adri"
    }
}

class VisibilytyThree: VisibilityTwo() {
    internal val age: Int? = null

    fun sayMyNameThree() {
        sayMyNameTwo()
    }
}