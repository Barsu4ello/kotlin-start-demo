package lesson7.xml

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "catalog")
class Catalog { // имя вообще любое и name можно не указывать в аннотациях

    //Аннотации нужны и для getter и для setter в отличии от java
    // еще кстати есть field вариант(для справки)
    @get:ElementList(required = false, inline = true, name = "book")
    @set:ElementList(required = false, inline = true, name = "book")
    var books: List<Book>? = null // тут тоже любое имя может быть и name можно не указывать в аннотациях
}

class Book {
    @get:Attribute(required = false)
    @set:Attribute(required = false)
    var id: String? = null

    @get:Element(required = false)
    @set:Element(required = false)
    var author: String? = null

    @get:Element(required = false)
    @set:Element(required = false)
    var title: String? = null

    @get:Element(required = false)
    @set:Element(required = false)
    var genre: String? = null

    @get:Element(required = false)
    @set:Element(required = false)
    var price: String? = null

    @get:Element(required = false, name = "publish_date")
    @set:Element(required = false, name = "publish_date")
    var publishDate: String? = null

    @get:Element(required = false)
    @set:Element(required = false)
    var description: String? = null
}