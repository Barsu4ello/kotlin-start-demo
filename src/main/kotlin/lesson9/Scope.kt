package lesson9

class Window {
    var width: Int = 0
    var height: Int = 0
    var isVisible: Boolean = false
}

fun main() {

    // also
    val string = "Hello World"
    string.also {
        println("\"$it\" length is ${it.length}")
        val helloWorld = "Hello" // не видно за пределами скоупа also
    }

    // run (1 вариант функции)
    val runVal1: Unit = run { println("run hello") }
    val runVal2: Int = run { 12 + 12 }
    println(runVal1)
    println(runVal2)

    // run (2 вариант функции)
    val map = mutableMapOf(1 to Window())

    val runWindow = map[2]?.run {
        width = 100
        isVisible = true
        this
    }

//    val runWindow = map[2]?.run (
//        fun Window.() : Window {
//            width = 100
//            isVisible = true
//            return this
//        }
//    )

    // with
    val builder = StringBuilder()
    val withBuilder = with(builder) {
        append("1")
        append("2")
        append(".")
        append("3")
    }
    println(withBuilder)

    // apply
    val apply = builder.apply {
        append(" apply")
    }
    println(apply)

    // let
    val myString: String? = "null"
    val let = myString?.let { println(it) }
    println(let)
}

