package lesson8.generics

class Box<T>(data: T) { // nullable вариант
//class Box<T : Any>(data: T) { // non-nullable вариант
    var value: T = data
}

fun <T> List<T>.getByNumbers(vararg numbers: Int): List<T> {
    val list = mutableListOf<T>()
    numbers.forEach { list.add(this[it]) }
    return list
}

fun main() {
    val intBox = Box(1)
    val numberBox: Box<Number> = Box(2.33)
    val nullableBox = Box(null)

    val list = listOf(1,2,3,4,5)
    val listByNumbers = list.getByNumbers(1,2,4)
    println(listByNumbers)
    throw NullPointerException()
}