package basicsyntax

class When {

    fun describe(obj: Any): String =
        when (obj) {
            1          -> "One"
            "Hello"    -> "Greeting"
            is Long    -> "Long"
            !is String -> "Not a string"
            else       -> "Unknown"
        }


}

fun main() {
    val whenObj = When()
    println(whenObj.describe(1))
    println(whenObj.describe("Hello"))
    println(whenObj.describe(1000L))
    println(whenObj.describe(2))
    println(whenObj.describe("other"))
}