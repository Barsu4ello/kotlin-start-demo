fun main(args: Array<String>) {

    //Создание массива
//    val arr: Array<Int> = arrayOf(1, 2, 3, 4, 5)
    val arr = arrayOf(1, 2, 3, 4, 5)
    arr[1] = 25
    println(arr)
    if(3 in arr) {
        println("Есть тройка")
    }

    val list = listOf("One", "Two", "Three", "Four")
    val mutableList = mutableListOf("one", "two", "three")
    println(mutableList.get(0))
    mutableList.add("Four")
    println(mutableList.last())
//    println(mutableList.last) // В котлине не используется(считается устаревшим) как и getLast(). Даже не скомпилируется

    // Пары
    val pair = Pair(1, "Four")
    println("first: ${pair.first}, second: ${pair.second}")

    val infixPair = 1 to "One"
    val (y,u) = 1 to "One"
    println("y: $y, u -> $u")

    val map = mutableMapOf(1 to "one", "face" to "face", "face1" to 1)
    println(map)
    println(map["face"])
    println(map[1])
    println(map["face1"])

    for((key, value) in map) {
        println("$key -> $value")
    }

    val triple = Triple(1, "Three", listOf(12,2,4))
    println(triple)
    println(triple.third)
    val (a,b,c) = Triple(1, "Three", listOf(12,2,4))
    println(a)
    println(b)
    println(c)

}

