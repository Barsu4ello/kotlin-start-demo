package lesson2.classes

class Person(val name: String, var isMarried: Boolean = false)


fun main(args: Array<String>) {
    val max = Person("Max")
    println("${max.name} ${max.isMarried}")
    println(max.toString())
}