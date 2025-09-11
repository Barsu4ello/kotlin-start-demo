package lesson8.generics

// Можно параметризовать T несколькими типами (1 классом и несколькими интерфейсами)
fun <T> appendDot(seq: T): T where T : CharSequence, T : Appendable {
    seq.append(".")
    return seq
}

fun main() {
    var stringBuilder = StringBuilder("123")

    println(appendDot(stringBuilder))
}