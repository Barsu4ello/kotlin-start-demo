package lesson5.lambdaFunctions

import lesson5.list
import lesson5.people

fun main() {

    // Создает Pair из соответсвующий элементов коллекций (первый с первым, второй со вторым и тд)
    println(people.zip(list))
    println(list.zip(people))
    println(people.zip(list) {person, number -> person.age + number}) // Вернет лист новых элементов, которые получается из лямбды
    println(people.zip(list) {person, number -> "${person.name} : $number"}) // Вернет лист новых элементов, которые получается из лямбды

    val nums = listOf(10, 20, 30, 40)
    println(nums.zipWithNext()) // создает пары соседних элементов [(10, 20), (20, 30), (30, 40)]
    val diffs = nums.zipWithNext { a, b -> b - a } // Вернет лист новых элементов, которые получается из лямбды
    println(diffs) // [10, 10, 10]
}