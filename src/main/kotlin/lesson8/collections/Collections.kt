package lesson8.collections

import okhttp3.internal.toImmutableList
import kotlin.collections.ArrayList

fun main() {

    //List
    val list = listOf(1, 2, 3, 4, 5) // ArrayList
    val list1 = listOf(1) // SingletonList
    val emptyList = listOf<Int>() // EmptyList
//    list[2] = 12; // не работает с неизменяемыми коллекциями
    val list2 = listOf(1, 2, 3, 4, 5)
    println(list == list2)

    val mutableList = mutableListOf<Int>() // ArrayList
    val mutableList1 = mutableListOf(1, 2, 3, 4, 5) // ArrayList
    mutableList.add(12)
    val arrayList = arrayListOf(1, 2, 3, 4) // ArrayList особо не нужен ибо тоже что и в mutableListOf

    //Set
    val set0 = setOf<Int>() // EmptySet
    val set01 = setOf(1) // SingletonSet
    val set1 = setOf(1, 2, 3, 4, 5) // LinkedHashSet

    val mutableSet1 = mutableSetOf(1, 2, 3, 4, 5) // LinkedHashSet
    val mutableSet2 = mutableSetOf<Int>() // LinkedHashSet
    //ниже все mutable set
    val set2 = hashSetOf(1, 2, 3, 4, 5) // HashSet
    val set3 = hashSetOf<Int>() // HashSet
    val set4 = sortedSetOf(1, 3, 4) // TreeSet
    val set5 = sortedSetOf<Int>() // TreeSet
    val set6 = linkedSetOf(1, 2, 3) // LinkedHashSet
    val set7 = linkedSetOf<Int>() // LinkedHashSet

    // Map
    val map0 = mapOf<Int, String>() // EmptyMap
    val map1 = mapOf(1 to "one") // SingletonMap
    val map2 = mapOf(1 to "one", 2 to "two", 3 to "three") // LinkedHashMap
    val map3 = mapOf(Pair(1, "one"), Pair(2, "two"), Pair(3, "three")) // LinkedHashMap

    val map4 = mutableMapOf(1 to "one", 2 to "two", 3 to "three") // LinkedHashMap
    val map5 = mutableMapOf<Int, String>() // LinkedHashMap
    //ниже все mutable map
    val map6 = hashMapOf(1 to "one", 2 to "two", 3 to "three") // HashMap
    val map7 = hashMapOf<Int, String>()  // HashMap
    val map8 = sortedMapOf(1 to "one", 2 to "two", 3 to "three") // Treemap
    val map9 = sortedMapOf<Int, String>() // TreeMap
    val map10 = linkedMapOf(1 to "one", 2 to "two", 3 to "three") // LinkedHashMap
    val map11 = linkedMapOf<Int, String>() // LinkedHashMap

    // Array (не связан с коллекциями) но там есть итератор для циклов for
    val array = arrayOf(1, 2, 3, 4, 5)

    // У них у всех свои типы(IntArray, DoubleArray и тд) и они не подтипы Array
    // Пустая функция и с параметрами это одна и та же функция
    val arrayByte = byteArrayOf()
    val arrayByte1 = byteArrayOf(1, 2, 3, 4, 5)
    val arrayShort = shortArrayOf()
    val arrayShort1 = shortArrayOf(1, 2, 3, 4, 5)
    val arrayInt = intArrayOf()
    val arrayInt1 = intArrayOf(1, 2, 3, 4, 5)
    val arrayLong = longArrayOf()
    val arrayLong1 = longArrayOf(1, 2, 3, 4, 5)
    val arrayFloat = floatArrayOf()
    val arrayFloat1 = floatArrayOf(1f, 2f, 3f, 4f, 5f)
    val arrayDouble = doubleArrayOf()
    val arrayDouble1 = doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0)
    val arrayChar = charArrayOf()
    val arrayChar1 = charArrayOf('a', 'b', 'c', 'd', 'e', 'f')
    val arrayBoolean = booleanArrayOf()
    val arrayBoolean1 = booleanArrayOf(true, false, true)
    val nullArray = arrayOfNulls<String>(10)
    val emptyArray = emptyArray<String>()

    array.get(1)
    array[1]
    array.set(1, 3)
    array[1] = 3

    val arr1 = arrayOf(arrayOf(1, 2), arrayOf(3, 4))
    val arr2 = arrayOf(arrayOf(1, 2), arrayOf(3, 4))
    val arr3 = arrayOf(1,2)
    val arr4 = arrayOf(1,2)

    println("Arrays")
    println(arr1 == arr2) // false (ссылки разные)
    println(arr1.contentEquals(arr2)) // false (сравнит только верхний уровень)
    println(arr1.contentDeepEquals(arr2)) // true ✅ (рекурсивное сравнение)
    println(arr3.contentEquals(arr4)) // true (сравнит только верхний уровень)
}