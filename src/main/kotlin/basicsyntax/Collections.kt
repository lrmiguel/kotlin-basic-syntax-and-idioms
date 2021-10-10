package basicsyntax

class Collections {
}

fun main() {
    val items = listOf("apple", "banana", "kiwifruit")

    for (item in items)
        println(item)

    when {
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple is fine too")
    }

    val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
    fruits
        .filter { it.startsWith("a") }
        .sortedBy { it }
        .map { it.uppercase() }
        .forEach { println(it) }
}