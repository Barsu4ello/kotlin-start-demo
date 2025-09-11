package lesson4

// инициализируется лишь раз в момент первого обращения
// во второй раз возвращает результат закешированный
val lazyValue: String by lazy {
    println("Инициализация!")
    "Hello World"
}

class LateInit{
    var name: String = "Misha"
    lateinit var late: String // lateinit только var(иначе как ты назначишь значение)

    fun init() {
        println(this::late.isInitialized) // узнаем проинициализировано ли поле на момент вызова метода isInitialized
        late = "Initialized"
        println(this::late.isInitialized)
    }
}

fun main() {
    println(lazyValue)
    println(lazyValue)

    var lateInit = LateInit()
//    lateInit.late // UninitializedPropertyAccessException если не проинизиализировать перед вызовом
    lateInit.init()
    println(lateInit.late)
}