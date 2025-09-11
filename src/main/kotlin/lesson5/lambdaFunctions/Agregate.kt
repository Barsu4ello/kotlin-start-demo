package lesson5.lambdaFunctions

import lesson5.map
import lesson5.people

fun main() {
    println(people.count()) // количество элементов в коллекции
    println(map.count()) // количество пар в коллекции
    println(people.map { it.age }.average())
    println(people.map { it.age }.sum())
    println(people.sumBy { it.age }) // Deprecated. Используй sumOf
    println(people.sumOf { it.age })
    println(people.sumByDouble { it.age.toDouble() }) // Deprecated. Используй sumOf
    println(people.map { it.age }.min())
    println(people.map { it.age }.max())
}