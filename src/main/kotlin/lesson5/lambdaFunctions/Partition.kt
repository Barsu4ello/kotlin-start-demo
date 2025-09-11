package lesson5.lambdaFunctions

import lesson5.people

fun main() {

    println(people.partition { it.age > 30 }) // Вернет 2 коллекции. Первая с объектами удовлетворяющими условию, вторая - не удовл.
}