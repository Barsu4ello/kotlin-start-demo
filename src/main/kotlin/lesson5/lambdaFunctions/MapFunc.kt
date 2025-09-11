package lesson5.lambdaFunctions

import lesson5.Person
import lesson5.list
import lesson5.people

fun main() {
    // 2 одинаковых варианта
    println(people.map(Person::name))
    println(people.map {it.name})
    println(list.map { Math.pow(it.toDouble(), 2.0) })
    println(list.map { it * it })
}