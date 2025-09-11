package lesson7.xml

import org.simpleframework.xml.core.Persister
import java.io.File
import javax.xml.parsers.DocumentBuilderFactory


fun main() {
/*
    //это DOM parser (есть еще потоковый SAX parser, он работает с большим объемом инфы но не хранит структуру)
    val builderFactory = DocumentBuilderFactory.newInstance()
    val dBuilder = builderFactory.newDocumentBuilder()
    val document = dBuilder.parse(File("src/main/resources/static/xml-example.xml"))
    val books = document.getElementsByTagName("book")
    for(i in 0 until  books.length) {
        val book = books.item(i)
        println(book.attributes.getNamedItem("id"))
        // тут по индексу может теги возвращать через 1 элемент (поэтому тут могут быть косяки).
        // ниже мини формула. Первая цифра это индекс
        println(book.childNodes.item(4 * 2 + 1).textContent)
    }
    */

    //simple xml библиотека
    val serializer = Persister()
    val catalog = serializer.read(Catalog::class.java, File("src/main/resources/static/xml-example.xml"))
    println(catalog.books!!.last().description)
}