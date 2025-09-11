package lesson2

fun main() {
    val line = "abc 123 def"

//    val regexp = """\d{3}"""
    val regexp = ".*\\d{3}.*"
    val pattern = regexp.toRegex()
    println(line.matches(pattern))
    println(pattern.matches(line))

    val regexp2 = ".{3}"
    val pattern2 = regexp2.toRegex()
    println(pattern2.containsMatchIn(line))

    println(date("12 JAN 2020"))

    html()

    log()

    passwd()
}

fun date(date: String): Boolean { // 12 JAN 2020
    val month = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)"
//    val (day, inpMonth, year) = date.split(" ")
//    val matches = inpMonth.matches(month)
//    require(day.toInt() in 1..31) { "Invalid day: $day" }
//    require(year.toInt() > 0) { "Invalid year: $year" }
//
//    return matches

    return date.matches("\\d{2} $month \\d{4}".toRegex())
}

fun html() {
    val html = "<html><head>hello</head><h1>heading</h1><p>Greeting</p1></html>"
    val pattern = "<[a-z]+>".toRegex()
    val findAll: Sequence<MatchResult> = pattern.findAll(html)
    for(find in findAll){
        println(find.value)
    }
}

val logLine = """
    2020-01-14 12:13:58.374 EET FINE: LOGIN (CASSystemUser): UserID="CASSystemUser", Client="Server client",
     Origin="193.42.108.58", SessionID="ad77c93f-b1e9-43c8-aa64-aff4630d8473" 
""".trimIndent()
fun log() {

    val regex = "(\\d{4}-\\d{2}-\\d{2}).+ LOGIN \\((.+)\\)".toRegex()
    val founded = regex.findAll(logLine)

    for(found in founded) {
        for((ind,group) in found.groupValues.withIndex()) { // в группе с нулевым индексом сам match =  2020-01-14 12:13:58.374 EET FINE: LOGIN (CASSystemUser). Его можно пропустить.
            if(ind == 0) continue
            println(group)
        }
    }
}


fun passwd() {
//    for(line in password.split("\n")) {
//        println(line.split(":")[0])
//    }
    //2 вариант
    val regex = """(.+):\*:.*\n""".toRegex()
    val findAll = regex.findAll(password)
    for(find in findAll){
        println(find.groupValues[1])

    }
}
