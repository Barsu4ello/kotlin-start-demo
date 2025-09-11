package lesson6.functions

import kotlin.random.Random

class LazyClass(initFunc: () -> Int) {
//    var initial = 0
//    init {
//        initial = initFunc()
//    }

    val initial by lazy {
        initFunc()
    }

}

fun main() {
    val lazyClass = LazyClass {
        println("init")
        Random.nextInt(10)
    }
    println(lazyClass.initial)
    println(lazyClass.initial)
}