package lesson4.kotlinLambda

import lesson4.lambda.JavaClickListener
import lesson4.lambda.JavaView

fun main() {
    val javaView = JavaView()

    // через анонимный класс
    javaView.setOnClickListener(object : JavaClickListener {
        override fun onClick(javaView: JavaView?) {
            println("without lambda")
        }
    })

    // через лямбду
    javaView.setOnClickListener { view -> println("lambda") }
    javaView.setOnClickListener { _ -> println("lambda") }
    javaView.setOnClickListener { println("lambda") }


    val sum = { x: Int, y: Int -> x + y }
    println(sum(1, 2));

    // сразу вызвать лямбду
    { println("Hello")}()
    // или
    run { println("Hello") }

}