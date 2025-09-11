package lesson2

fun main() {

    for (i in 1..25)
        println(fizzBuzz(i))

}

//fun fizzBuzz(data: Int): String {
//    when {
//        data % 5 == 0 && data % 3 == 0 -> return "FizzBuzz: $data"
//        data % 3 == 0 -> return "Fizz: $data"
//        data % 5 == 0 -> return "Buzz: $data"
//    }
//
//    return data.toString()
//}

//fun fizzBuzz(data: Int) = when {
//    data % 5 == 0 && data % 3 == 0 -> "FizzBuzz: $data"
//    data % 3 == 0 -> "Fizz: $data"
//    data % 5 == 0 -> "Buzz: $data"
//    else -> "$data"
//}

fun fizzBuzz(data: Int): String {
    return when {
        data % 5 == 0 && data % 3 == 0 -> "FizzBuzz: $data"
        data % 3 == 0 -> "Fizz: $data"
        data % 5 == 0 -> "Buzz: $data"
        else -> "$data"
    }
}

