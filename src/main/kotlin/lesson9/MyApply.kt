package lesson9

//fun <T> T.myApply(func: T.() -> Unit): T {
//    this.func()
//    return this
//}

// тоже через apply
fun <T> T.myApply(func: T.() -> Unit): T = apply(func)

fun createMap(): Map<Int, String> {

    return hashMapOf<Int, String>().myApply {
        put(0, "zero")
        for (i in 1..10)
            put(i, "$i")
    }
}

fun main() {
    val createMap = createMap()
    println(createMap)
}