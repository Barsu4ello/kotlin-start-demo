package lesson1

fun main(args: Array<String>) {
    //if
    val temperature = 26
    // Можно присвоить переменной значение из if else (можно и из try catch)
//    val condition =
//        if (temperature < -5)
//            "Холодно"
//        else if (temperature < 5)
//            "Около нуля"
//        else
//            "Жарко"
        // Тоже что и выше но через when
    val condition =
        when {
            temperature < -5 -> "Холодно"
            temperature < 5 -> "Около нуля"
            else -> "Жарко"
        }

    println(condition)

    val result = try {
        val number = "123a".toInt()  // тут будет ошибка
        "Число: $number"
    } catch (e: NumberFormatException) {
        "Ошибка: неправильный формат числа"
    }

    println(result)  // Ошибка: неправильный формат числа

}