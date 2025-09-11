package lesson1

fun main(args: Array<String>) {

    //while и do/while как на java
    while (false) {
        TODO("Логика цикла")
    }

    // loop это аналог лейблов (их можно даже ипользовать в лямбдах(в стримах))
    loop@ do {
//        TODO("Логика цикла")  // Бросает ошибку по достижению
         break@loop
    } while (false)

        //Сравнения через == аналогично equals, а через === аналогично сравнению по адресу памяти

    //for(int i = 0; i< 0; i++) нет
    // НО есть ДИАПОЗОНЫ
    val oneToFive = 1..5
    val letters = 'a'..'d'
    val words = "Java".."Yaml"

    if('d' in letters)
        println("d in letters")

    if("Kotlin" in words)
        println("Kotlin in words")

    for(figure in oneToFive)
        println("$figure")



}