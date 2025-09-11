package lesson5.lambdaFunctions

import lesson5.map

fun main() {

    println(map)
    println(map.mapValues { it.value.uppercase() })
    println(map.mapKeys { it.key + 1 })

    val flat = map.flatMap { (key, value) ->
        // превращаем каждый элемент в список символов value + ключ
        listOf(key) + value
    }
    println(flat)
    println(flat[0].javaClass)
    println(flat[1].javaClass)
}