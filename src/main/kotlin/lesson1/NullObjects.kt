package lesson1

fun main(): Unit {
    var position: String? = "programmer"
    position = null
    if (position != null) {
        println("length is " + position.length)
    }
    println("length is " + (position?.length))

//    println("length is " + position!!.length)

    println("length is " + (position?.length ?: 0))
    println("length is " + position?.length ?: 0)
    println("length is ${position?.length ?: 0}")

//    println(String.valueof(null));


}

