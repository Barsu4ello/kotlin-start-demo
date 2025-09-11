package lesson5.lambdaFunctions

import lesson5.listOfList

fun main() {

    println(listOfList.flatten().flatMap{ it.toList() })
}