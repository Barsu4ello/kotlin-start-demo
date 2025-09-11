package lesson3.tasks

//fun isValidId(id: String): Boolean {
//    if(!(id.get(0).isDigit() || id.get(0).isLetter()))
//        return false
//
//    if(!id.matches("[a-zA-Z0-9_а-яА-Я]+".toRegex()))
//        return false
//
//    if(id.length < 5)
//        return false
//
//    return true
//}
fun isValidId(id: String): Boolean {
    return id.matches("^[a-zA-Z0-9][a-zA-Z0-9_а-яА-Я]{4,}".toRegex())
}

fun main() {
   for(i in 1..10) {
       println(isValidId(readln()))
   }
}