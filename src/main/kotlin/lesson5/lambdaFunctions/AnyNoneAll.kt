package lesson5.lambdaFunctions

import lesson5.people

fun main() {
    // Any - если хотя бы 1 элемент соответствует то true
    println(people.any { it.age == 29 }) // true
    println(people.any { it.age == 18 }) // false

    // None - нет ни одного объекта который соответствовал нашему критерию (все не соответствуют)
    println(people.none { it.age == 29 }) // false
    println(people.none { it.age == 18 }) // true

    // All - все элементы соответствуют условию
    println(people.all { it.name.length >= 3 }) // true
    println(people.all { it.age == 18 }) // false
}