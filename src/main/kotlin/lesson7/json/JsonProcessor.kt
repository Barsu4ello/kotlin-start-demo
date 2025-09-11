package lesson7.json

import com.google.gson.Gson
import org.json.JSONObject
import java.io.FileNotFoundException

val json = object {}.javaClass.getResource("/static/json-example.json")?.readText()
    ?: throw FileNotFoundException("Файл не найден")

fun main() {
   /*
   // библиотека org.json:json:20250517
    val obj = JSONObject(json)
    println(obj.getString("owner"))
    println(obj.getInt("age"))
    val books = obj.getJSONArray("books")
    println(books)
    val book = books.getJSONObject(0)
//    val book = books[1] as JSONObject
    println(book.getString("author"))
    */

    // библиотека com.google.code.gson:gson:2.13.1
    val gson = Gson()
    val owner = gson.fromJson(json, BookOwner::class.java)
    println(owner)
    println(owner.books)
    println(owner.books[1].author)

    println(gson.toJson(owner))
}


// классическая работа с Json через ObjectMapper но на котлине
//fun main() {
//    val mapper = jacksonObjectMapper()
//    val obj: Any = mapper.readValue(json) // автоматически определяет тип
//    println(obj)
//}