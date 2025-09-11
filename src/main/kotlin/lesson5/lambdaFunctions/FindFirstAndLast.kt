package lesson5.lambdaFunctions

import lesson5.people

fun main() {
    println(people.first { it.age == 31 })
//    println(people.first { it.age == 60 }) // NoSuchElementException
    println(people.firstOrNull { it.age == 60 }) // null вместо NoSuchElementException
    println(people.last { it.age == 31 })
//    println(people.last { it.age == 60 }) // NoSuchElementException
    println(people.lastOrNull { it.age == 60 }) // null вместо NoSuchElementException
}