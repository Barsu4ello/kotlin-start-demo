package lesson5.lambdaFunctions

import lesson5.people

fun main() {
    println(people.find { it.age == 31 }) // внутри firstOrNull
}