package idioms

//Only the property name will be used inside the toString(), equals(), hashCode(), and copy() implementations, and there will only be one component function component1()
data class Person(val name: String) {
    var age: Int = 0
}

data class User(val name: String, val age: Int)

fun main() {
    val person1 = Person("John")
    val person2 = Person("John")
    person1.age = 10
    person2.age = 20
//    While two Person objects can have different ages, they will be treated as equal.
    println("person1 == person2: ${person1 == person2}")
    println("person1 with age ${person1.age}: ${person1}")
    println("person2 with age ${person2.age}: ${person2}")

    val jack = User(name = "Jack", age = 1)
    val olderJack = jack.copy(age = 2)
    println("Jack = $jack, OlderJack = $olderJack")

    val jane = User("Jane", 35)
    val (name, age) = jane
    println("$name, $age years of age")
}