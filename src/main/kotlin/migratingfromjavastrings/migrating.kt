package migratingfromjavastrings

fun main() {
    // Java
    /*String name = "Joe";
    System.out.println("Hello, " + name);
    System.out.println("Your name is " + name.length() + " characters long");*/

    // Kotlin
    val name = "Joe"
    println("Hello, $name")
    println("Your name is ${name.length} characters long")

    // Build a string
    // In Java, you can use the StringBuilder
    // Java
    /*StringBuilder countDown = new StringBuilder();
    for (int i = 5; i > 0; i--) {
        countDown.append(i);
        countDown.append("\n");
    }
    System.out.println(countDown);*/

    // Kotlin
    val countDown = buildString {
        for (i in 5 downTo 1) {
            append(i)
            appendLine()
        }
    }
    println(countDown)
    // Under the hood, the buildString uses the same StringBuilder class as in Java, and you access it via an implicit this inside the lambda.

    // Create a string from collection items
    /*In Java, you use the Stream API to filter, map, and then collect the items:

    // Java
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
    String invertedOddNumbers = numbers
            .stream()
            .filter(it -> it % 2 != 0)
            .map(it -> -it)
            .map(Object::toString)
        .collect(Collectors.joining(", "));
    System.out.println(invertedOddNumbers);*/

    // In Kotlin, use the joinToString() function, which Kotlin defines for every List:
    val numbers = listOf(1, 2, 3, 4, 5, 6)
    val invertedOddNumbers = numbers
        .filter { it % 2 != 0 }
        .joinToString { "${-it}" }
    println(invertedOddNumbers)
}