package lesson5.lambdaFunctions

import lesson5.list
import lesson5.people

fun main() {
    println(list.distinct())
    println(people.distinctBy { it.age }) // передаем критерий по которому сравнивается уникальность(в данном случае отбирает по уникальному возрасту)
}