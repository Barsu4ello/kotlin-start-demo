package lesson1

fun main(args: Array<String>) {
    val obj : Any = "15"

//    obj.length не фурычит, но через if с is работает
    if(obj is String){
        println(obj.length)
    }

    // is можно использовать с отрицанием !
//    if(obj !is String){
//        println(obj.length)
//    }

    val x:String = obj as String

    val age = 15
//    val z:String = age as String //ClassCastException
    val z: String? = age as? String // as? позволяет сделать приведение любых типов(если приведение будет неудачным то вместо ClassCastException будет null
    println(z)
}