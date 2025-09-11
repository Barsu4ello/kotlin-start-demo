package lesson5.lambdaFunctions

import lesson5.people

fun main() {
    // кол-во элементов
    println(people.count())
    // кол-во элементов по критерию
    println(people.count { it.age > 30 })
}