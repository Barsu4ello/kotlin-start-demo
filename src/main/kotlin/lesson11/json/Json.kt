package lesson11.json

import com.google.gson.JsonArray
import com.google.gson.JsonObject


class JsonObjectBuilder {
    val json = JsonObject()

    infix fun String.to(second: String) = json.addProperty(this, second)

    infix fun String.to(block: JsonObjectBuilder.() -> Unit) {
        val newNode: JsonObject = json(block)
        json.add(this, newNode)
    }

    infix fun String.to(array: JsonArray) = json.add(this, array)

    fun array(block: JsonArrayBuilder.() -> Unit): JsonArray {
        val builder = JsonArrayBuilder()
        builder.block()
        return builder.json
    }

}

class JsonArrayBuilder {
    val json = JsonArray()

    operator fun String.unaryPlus() : Unit = json.add(this)

}

fun json(block: JsonObjectBuilder.() -> Unit): JsonObject {
    val builder = JsonObjectBuilder()
    builder.block()
    return builder.json
}

// переопределяем или как статическую внешнюю или как внутреннюю функцию класса(разница в видимости)
//fun array(block: JsonArrayBuilder.() -> Unit): JsonArray {
//    val builder = JsonArrayBuilder()
//    builder.block()
//    return builder.json
//}

fun main() {


    val json = json {
        "course" to "Kotlin2"
        "data" to {
            "from" to "03-02-2020"
            "to" to "14-02-2020"
        }
        "students" to array {   // уточнить получится потом ли со скобками
            +"one"
            +"two"
            +"three"
        }
    }

    println(json)

}