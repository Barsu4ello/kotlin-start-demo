package lesson8.generics

class Bitmap

class Result<T>(val result: T?, val throwable: Throwable?)

fun main() {
    val bitmap = Bitmap()
    val result = Result(bitmap, null)

    val throwable = Throwable("Error")
    val error = Result(null, throwable)
}