package lesson5.lambdaFunctions

import lesson5.people

fun main() {

    println(people.groupBy { it.age })
    println(people.groupBy({ it.age }, { it.name })) // Сгруппирует не самих Person по возрасту, а их имена по возрасту

    println(people.associateBy { it.age }) // то же что и groupBy но вернет не ключ(возраст) и список Person, а только последнего Person из группы
}