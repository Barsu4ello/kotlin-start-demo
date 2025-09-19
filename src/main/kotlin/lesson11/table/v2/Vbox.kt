package lesson11.table.v2

//Можно было и думаю в библиотеки настоящей вместо button и label классы. Но я для удобства строки заюзал
class Vbox(private var button: String = "", private var label: String = "") {
    fun button(str:String) {button = str}
    fun label(str:String) {label = str}
}

fun vbox(block: Vbox.() -> Unit): Vbox = Vbox().apply(block)

fun main() {

    val v = vbox {
        button("Press me")
        label("Waiting")
    }
}