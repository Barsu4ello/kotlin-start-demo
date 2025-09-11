package lesson8.retrofitJson

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl("https://dictionary.yandex.net")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val yandexDictionaryService = retrofit.create(YandexDictionaryService::class.java)

fun main() {
    val response = yandexDictionaryService.lookup("en-ru", "dog").execute()
    if (response.isSuccessful) {
        val result = response.body()
        println(
            result?.def?.get(0)?.tr?.get(0)?.text
        )
    }
}