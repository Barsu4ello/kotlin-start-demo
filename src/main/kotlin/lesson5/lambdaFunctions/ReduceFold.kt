package lesson5.lambdaFunctions

import lesson5.list
import lesson5.people

fun main() {
    println(list.fold(1) { acc, it -> acc * it })
    println(people.fold(1) { acc, it -> acc * it.age })

    println(list.reduce { acc, it -> acc * it }) // то же что и fold, но начальное значение = первому элементу
//    println(people.reduce { acc, it -> acc * it.age }) // c Person не прокатит
}