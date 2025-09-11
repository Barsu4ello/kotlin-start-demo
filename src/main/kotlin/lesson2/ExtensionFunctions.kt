package lesson2

//fun String.lastChar(): Char = this.last()
//аналог функции выше
fun String.lastChar(): Char = last()

fun <T> List<T>.getFirstElement(): T = get(0)

fun List<String>.getSecondElement(): String = get(1)

fun String.allMatchesOf(regex: Regex): List<String>  {
//    val findAll = regex.findAll(this)
//    val list = mutableListOf<String>()
//    for(element in findAll){
//        list.add(element.value)
//    }
//    return list

    //аналогичный метод
    return regex.findAll(this)
        .map { it.value }
        .toList()
}

fun main() {
    println("12367".lastChar())
    val listOf = listOf("123", "234", "345")
    val firstElement = listOf.getFirstElement()
    println(firstElement)
    println(listOf.getSecondElement())

    val listNum = listOf(1, 2, 3)
    println(listNum.getFirstElement())

    val testString1 = "123123123"
    val testString2 = "123123123123"
    val allMatchesOf1 = testString1.allMatchesOf("123".toRegex())
    println(allMatchesOf1)
    val allMatchesOf2 = testString2.allMatchesOf("123".toRegex())
    println(allMatchesOf2)

    val html = "<html><head>hello</head><h1>heading</h1><p1>Greeting</p1></html>"
    val pattern = "<[a-z1-9]+>".toRegex()
    val allMatchesOf3 = html.allMatchesOf(pattern)
    println(allMatchesOf3)
}

