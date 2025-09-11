package lesson5.lambdaFunctions

import lesson5.list
import lesson5.nullableList
import lesson5.nullableList2
import lesson5.people

//ФИЛЬТРАЦИЯ.

fun main() {

    // Заметь что стрим не ленивый в котлин и достаточно filter{} для получения значения
//    println(list.filter { x:Int -> x % 3 == 0  })
//    println(list.filter { x -> x % 3 == 0  })
    println(list.filter { it % 3 == 0 })
    //Второй вариант из джавы и синтаксис немного другой. Тут фигурные скобки
    println(list.stream().filter { it % 3 == 0 }.toList())

    println(people.filter { it.age > 30 })

    // не сработает из за деления возможного null значения
//    println(nullableList.filter { it % 3 == 0 })
    //тогда есть 2 варианта
    println(nullableList.filter {it != null && it % 3 == 0 })
    println(nullableList.filterNotNull().filter { it % 3 == 0 })
    println(nullableList2?.filterNotNull()?.filter { it % 3 == 0 })
}