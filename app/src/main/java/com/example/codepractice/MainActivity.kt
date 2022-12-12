package com.example.codepractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.thread

// Para tipos de datos, funciones y clases anidadas
typealias MyMapList = MutableMap<Int, ArrayList<String>>
typealias MyFun = (Int, String, MyMapList) -> Boolean
typealias MyNestedClass = MyNestedAndInnerClass.MyNestedClass

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Enum Classes
        enumClasses()

        // Nested and Inner Classes
        nestedAdnInnerClases()

        // Class Inheritance
        classInheritance()

        // Interfaces
        interfaces()

        // Visibility Modifiers
        visibilityModifiers()

        // Data Classes
        dataClasses()

        // Type Alias
        typeAliases()

        // Destructuring declarations
        destructuringDeclarations()

        // Extensions
        extensions()

        // Lamdas
        lamdas()
    }

    // Lección ENUM
    enum class Direction(val dir : Int) {
        NORTH(1), SOUTH(-1), EAST(1), WEST(-1);

        fun description() : String {
            return when (this) {
                NORTH -> "Es NORTH"
                SOUTH -> "Es SOUTH"
                EAST -> "Es EAST"
                WEST -> "Es WEST"
            }
        }
    }

    private fun enumClasses() {
        // Asignacion de valores
        var userDirection: Direction? = null
        println("Direccion: $userDirection")

        userDirection = Direction.NORTH
        println("Direccion: $userDirection")

        // Propiedades por defecto
        println("Name: ${userDirection.name}")
        println("Ordinal: ${userDirection.ordinal}")

        // Funciones
        println(userDirection.description())
    }

    // Nested And Inner Class
    private fun nestedAdnInnerClases() {
        // Clase anidada
        val myNestedClass = MyNestedClass()
        val sum = myNestedClass.sum(10, 5)
        println(sum)

        //Clase interna
        val myInnerClass = MyNestedAndInnerClass().MyInnerClass()
        val sumTwo = myInnerClass.sumTwo(10)
        println(sumTwo)
    }

    // Class Inheritance
    private fun classInheritance() {

        val person = Person("Sara", 40)

        val programmer = Programmer("Adri", 22, "Kotlin")
        programmer.work()
        programmer.sayLanguage()
        programmer.goToWork()
        programmer.drive()

        val designer = Designer("Lolo", 10)
        designer.work()
        designer.goToWork()
    }

    // Interfaces
    private fun interfaces() {
        val gamer = Person("Adri", 22)
        gamer.play()
        gamer.stream()
    }

    // Visibility Modifiers
    private fun visibilityModifiers() {
        /*val visibility = Visibility()
        visibility.name = "Adri"
        visibility.sayMyName()*/

        val visibilityTwo = VisibilityTwo()
        // visibilityTwo.sayMyNameTwo

        val visibilityThree = VisibilytyThree()
        visibilityThree.sayMyNameThree()
    }

    // Data Classes
    private fun dataClasses() {
        val adri = Worker("Adri", 22, "Programadora")
        adri.lastWork = "student"

        val sara = Worker()
        val adriTwo = Worker("Adri", 22, "Programadora")

        // equals & hashCode
        if (adri.equals(sara)) {
            println("Iguales")
        } else {
            println("diferentes")
        }

        if (adri == adriTwo) {
            println("Iguales")
        } else {
            println("diferentes")
        }

        // toString
        println(adri.toString())

        // copy
        val adriThree = adri.copy(age = 21)
        println(adri.toString())
        println(adriTwo.toString())
        println(adriThree.toString())

        // ComponentN -> descompone al objeto en elementos más pequeños
        val (name, age) = adriTwo
        println(name)
        println(age)
    }

    // Type Alias
    private var myMap: MyMapList = mutableMapOf()
    private fun typeAliases() {
        var myNewMap: MyMapList = mutableMapOf()
        myNewMap[1] = arrayListOf("Adri", "Calvo")
        myNewMap[2] = arrayListOf("Adriana", "Bueno")

        myMap = myNewMap
    }

    // Destructuring declarations
    private fun destructuringDeclarations() {

        val (name, age, work) = Worker("Adriana Calvo", 22, "Programador")
        println("$name, $age, $work")

        val (name2, _, work2) = Worker("Adriana Calvo", 22, "Programador")
        println("$name2, $work2")

        val adri = Worker("Adriana Calvo", 22, "Programador")
        println(adri.name)

        val (name1, age1, work1) = myWorker()

        val myMap = mapOf(1 to "Adri", 2 to "Adri2")
        for (element in myMap) {
            println("${element.key}, ${element.value}, ${element.component1()}")
        }
        for ((id, name) in myMap) {
            println("$id, $name")
        }
    }

    private fun myWorker(): Worker {
        return Worker("Adriana Calvo", 22, "Programador")
    }

    // Extensions
    private fun extensions() {
        val myDate = Date()
        println(myDate.customFormat())
        println(myDate.formatSize)

        val myDateNullable: Date? = null
        println(myDateNullable.customFormat())
        println(myDateNullable.formatSize)
    }

    // Lambdas - funciones que trabajan con otras funciones
    private fun lamdas(){
        val myIntList = arrayListOf<Int>(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val myFilterIntList = myIntList.filter { myInt ->
            println(myInt)
            if (myInt == 1) {
                return@filter true
            }
            myInt > 5
        }
        println(myFilterIntList)

        val mySumFun = fun(x: Int, y: Int): Int {
            return x + y
        }
        val myMultFun = fun(x: Int, y: Int): Int {
            return x * y
        }

        myAsyncFun("Adri") {
            println(it)
        }

        println(myOperateFun(5, 10, mySumFun))
        println(myOperateFun(5, 10, myMultFun))

        myOperateFun(5, 10) { x, y ->
            x - y
        }
    }

    private fun myOperateFun(x: Int, y: Int, myFun: (Int, Int) -> Int): Int {
        return myFun(x, y)
    }

    // Asincrono, tipo callback
    private fun myAsyncFun(name: String, hello: (String) -> Unit) {
        val myNewString = "Hello $name"
        hello(myNewString)

        thread {
            Thread.sleep(5000)
            hello(myNewString)
        }
    }
}