package lesson5.lambdaFunctions

import lesson5.listOfList

fun main() {

    println(listOfList.flatten()) // коллекцию коллекций превращает в один лист
    println(listOfList.flatMap { it }) // аналог flatten()
}