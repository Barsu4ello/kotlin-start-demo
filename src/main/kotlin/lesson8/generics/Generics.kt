package lesson8.generics

// Ключевое различие с джава в последнем примере
// Если в джава мы опирались на наследование и использовали соответственные слова extends и super
// то в котлине с in может справа стоять nullable тип хотя слева это не указано
// но это безопасно(вставить null нельзя все равно, а только цифры, что удовлетворит тип справа)
fun main() {
    // так можно ибо лист только на чтение.
    val listOfNumbers: List<Number> = listOf<Int>(1,2,3,4,5)
    // Хоть и справа мутабельный лист но если слева не мутабельный то тоже можно
    val mutableListOfNumbers: List<Number> = mutableListOf<Int>(1,2,3,4,5)
    val number: Number = mutableListOfNumbers[0] // аналогично джаве только Number и ваше в левой части

    // тут аналогично джаве нельзя ибо можно будет в последствии добавить в Int лист Double
    // val mutableListOfNumbers2: MutableList<Number> = mutableListOf<Int>(1,2,3,4,5) // не работает

    // но можно указать out Number, что говорит что это наследники Number и запретит добавлять элементы
    val mutableListOfNumbers2: MutableList<out Number> = mutableListOf<Int>(1,2,3,4,5)
    // mutableListOfNumbers2.add(11) // но в такой лист как и в джава ничего не добавить (и null тоже)
    val number2:Number = mutableListOfNumbers2[0] // аналогично джаве только Number и ваше в левой части

    // но можно указать out Number, что говорит что это наследники Number и запретит добавлять элементы
    val mutableListOfNumbers3: MutableList<in Number> = mutableListOf<Any>(1,2,3,4,5) // Number или выше справа
     mutableListOfNumbers3.add(11) // можно добавлять Number и его наследников
    // а тут можно получить только Any так еще и nullable(ибо при объявлении листа мы могли справа указать Any?)
    val number3:Any? = mutableListOfNumbers3[0]

//    var anyNonNull: Any = 12
//    var any: Any? = null
//
//    // any = anyNonNull
//    anyNonNull = any // так нельзя ибо Any это подтип Any?
//    println(anyNonNull is Any?)

}
