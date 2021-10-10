package idioms

import java.io.File
import java.math.BigDecimal
import java.nio.file.Files
import java.nio.file.Paths

fun foo(a: Int = 0, b: String = "") {
    println("a=$a, b=$b")
}

fun main(args: Array<String>) {
    // Default values for function parameters
    foo(45, "forty five")

    // Filter a list
    val list = listOf(2, -3, 4)
//    val positives = list.filter { x -> x > 0 }
    // Or alternatively, even shorter:
    val positives = list.filter { it > 0 }
    println(positives)

    // Check the presence of an element in a collection
    if (2 in list) {
        println("$list has 2 member")
    }

    if (-9 !in list) {
        println("$list has no -9 member")
    }

    // Instance checks
    val x = Foo()
    when (x) {
        is Foo -> println("$x is Foo")
        is Bar -> println("$x is Bar")
        else -> println("$x is neither Foo or Bar")
    }

    // Read-only list﻿
    val list2 = listOf("a", "b", "c")
    println("Read-only list: $list2")

    // Read-only map
    val map = mapOf("a" to 1, "b" to 2, "c" to 3)
    println("Read-only map: $map")

//    Access a map entry
    val mutableMap = mutableMapOf("a" to 0, "b" to 3, "c" to 6)
    mutableMap["a"] = 2
    println("Acessing key a value: ${mutableMap["a"]}")

    // Traverse a map or a list of pairs﻿
    for ((k, v) in map) {
        println("$k -> $v")
    }

    // Iterate over a range
    /*for (i in 1..100) { ... }  // closed range: includes 100
    for (i in 1 until 100) { ... } // half-open range: does not include 100
    for (x in 2..10 step 2) { ... }
    for (x in 10 downTo 1) { ... }
    if (x in 1..10) { ... }*/

    // Lazy property
    val p: String by lazy {
        "lazyString"
    }
    println("Lazy property p: $p")

    // Extension functions
    fun String.spaceToCamelCase(): String {
        val words = this.split(" ")
        return words
            .reduce { total, word ->
                (total.substring(0 until 1).lowercase() + total.substring(1)) +
                        word.substring(0 until 1).uppercase() + word.substring(1)
            }
    }

    val a = "This should be camel case and not spaced"
    println("Extension Function spaceToCamelCase: before -> $a, after -> ${a.spaceToCamelCase()}")

    val resource1 = Resource
    val resource2 = Resource
    resource2.name = "lastname"
    println("Singleton: (${resource1.name}), (${resource2.name})")

    // Instantiate an abstract class
    val myObject = object : MyAbstractClass() {
        override fun doSomething() {
            println("doing something")
        }

        override fun sleep() {
            println("sleeping")
        }
    }
    myObject.doSomething()

    // If-not-null shorthand
    val files = File("Test").listFiles()

    println(files?.size) // size is printed if files is not null

    // If-not-null-else shorthand
    println(files?.size ?: "empty") // if files is null, this prints "empty"

    // Execute a statement if null
    val values = mapOf("name" to "leo", "email" to "leo.rmiguel@gmail.com")
    println(values["email"] ?: throw IllegalStateException("Email is missing!"));

    // Get first item of a possibly empty collection
    val mainEmail = list.firstOrNull() ?: ""

    // Execute if not null
    var value: String? = null
    value?.let {
        println("This block won't be executed")
    }

    // Return on when statement
    fun transform(color: String): Int {
        return when (color) {
            "Red" -> 0
            "Green" -> 1
            "Blue" -> 2
            else -> throw IllegalArgumentException("Invalid color param value")
        }
    }

    // Map nullable value if not null
    value = "Red"
    value.let { transform(it) } ?: "" // defaultValue is returned if the value or the transform result is null.

    // try-catch expression
    fun count() = 1
    val result = try {
        count()
    } catch (e: ArithmeticException) {
        throw IllegalStateException(e)
    }
    println(result)

    // if expression
    val value2 = 1
    val result2 = if (value2 == 1) {
        "one"
    } else {
        "two"
    }
    println(result2)

    // Builder-style usage of methods that return Unit
    fun arrayOfMinusOnes(size: Int): IntArray {
        return IntArray(size).apply { fill(-1) }
    }
    arrayOfMinusOnes(3).forEach { print(it) }

    // Single-expression functions
    fun theAnswer() = 42
    println(theAnswer())

    // Call multiple methods on an object instance (with)
    val myTurtle = Turtle()
    with(myTurtle) { //draw a 100 pix square
        penDown()
        for (i in 1..4) {
            forward(100.0)
            turn(90.0)
        }
        penUp()
    }
    // Configure properties of an object (apply)
    val myRectangle = Rectangle().apply {
        length = 4
        breadth = 5
        color = 0xFAFAFA
    }
    // This is useful for configuring properties that aren't present in the object constructor.
    println("${myRectangle.breadth}")

    // Java 7's try-with-resources
    val stream = Files.newInputStream(Paths.get(ClassLoader.getSystemResource("file.txt").toURI()))
    stream.buffered().reader().use { reader ->
        println(reader.readText())
    }

    // Nullable Boolean
    /* val b: Boolean? = ...
    if (b == true) {
        ...
    } else {
        // `b` is false or null
    }*/

    // Swap two variables
    var a1 = 1
    var b = 2
    a1 = b.also { b = a1}
    println("Swapped variables a=$a1, b=$b")

    fun calcTaxes(): BigDecimal = TODO("Waiting for feedback from accounting")
}

// Generic function that requires the generic type information
//  public final class Gson {
//     ...
//     public <T> T fromJson(JsonElement json, Class<T> classOfT) throws JsonSyntaxException {
//     ...

//inline fun <reified T: Any> Gson.fromJson(json: JsonElement): T = this.fromJson(json, T::class.java)

class Rectangle(var length: Int = 0) {
    var breadth: Int = 0
    var color: Any = 0
}

class Turtle {
    fun penDown() = "penDown"
    fun penUp() = "penUp"
    fun turn(degrees: Double) = "turn $degrees degrees"
    fun forward(pixels: Double) = "forward $pixels px"
}

abstract class MyAbstractClass {
    abstract fun doSomething()
    abstract fun sleep()
}

// Create a singleton
object Resource {
    var name = "Name"
}

open class Foo {

}

class Bar : Foo() {

}
