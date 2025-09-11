package lesson6.functions



class Counter {
    var numberOfGets = 0

    var number: Int = 0
        get() {
            numberOfGets++
            return field
        }
}

fun main() {
    val counter = Counter()
    counter.number
    counter.number
    println(counter.numberOfGets)
}