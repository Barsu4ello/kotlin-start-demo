package lesson1

fun main() {
    var first = "first"
    var second = "second"
    var figure = 1

    // java style
    println(" Первая переменная: " + first + " вторая : " + second + " цифра: "  + figure)
    // kotlin style
    println(" Первая переменная: $first вторая : $second цифра: $figure")
    println(" Первая переменная: ${first +  second}  вторая : $second цифра: $figure \$")
    println(" Первая переменная: ${"$first $second"}  вторая : $second цифра: $figure \$")
    println(" Первая переменная: ${first +  second + figure}  вторая : $second цифра: $figure \$")

    // java style
    println("\\")
    // kotlin style
    println("""\""")
    println("""\ \${first}""")
    println("""\ $""")
    println("""
        $first line
        $second line
        three line 
    """.trimIndent()) // trimIndent обрезает все строки

    println("""
        $first line
        $second line
        three line 
    """)

    println("""
        $first line
        |$second line
        |three line 
    """.trimMargin()) // отрежет все что слева от | в каждой строке (в нашем варианте в первой строке не отрежет)

    val testString = "testString"
    println(testString.get(3))
    println(testString[3])

}