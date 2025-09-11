package lesson5.lambdaFunctions

import lesson5.Person
import lesson5.people

// Возвращает объект из списка по определенному критерию(мин или макс)
fun main() {
    println(people.minBy{it.age})
    println(people.maxBy{it.age})
//    println(listOf<Person>().minBy{it.age}) // NoSuchElementException
    println(listOf<Person>().minByOrNull{it.age})  // null вместо NoSuchElementException
}