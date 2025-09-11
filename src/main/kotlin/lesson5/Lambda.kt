package lesson5

data class Person(val name: String, val age: Int)

val people = listOf(
    Person("Alice", 29),
    Person("Bob", 31),
    Person("Carol", 31)
)

val list = listOf(1, 2, 3, 4, 5, 6, 7, 1, 1, 1)
val nullableList: List<Int?> = listOf(1, 2, 3, null, 6, 8, 9)
val nullableList2: List<Int?>? = null // nullable лист, который может содержать nullable элементы

val map = mapOf(1 to "one", 2 to "two", 3 to "three")

val listOfList = listOf(
    listOf("abc", "kgb", "cia"),
    listOf("ibm", "kpmg")
)

fun main() {
    val sum = { x: Int, y: Int -> x + y }
    val print: () -> Unit = { println("hello") }

//    val result = sum(1, 2)
    //Тоже самое. Внутри обычный функциональный интерфейс с одним методом invoke.
    val result = sum.invoke(1, 2)

//    val printResult = print()
    val printResult = print.invoke()
}

