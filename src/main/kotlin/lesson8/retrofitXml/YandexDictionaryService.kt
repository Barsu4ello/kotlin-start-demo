package lesson8.retrofitXml

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

// https://dictionary.yandex.net/api/v1/dicservice/lookup?key=dict.1.1.20250903T172052Z.8c58e8e3b2abcecc.cd16d8eaea5fb8823fb9ff6f97ddb1ed88c0c2bf&lang=en-ru&text=time

private const val KEY = "dict.1.1.20250903T172052Z.8c58e8e3b2abcecc.cd16d8eaea5fb8823fb9ff6f97ddb1ed88c0c2bf"

interface YandexDictionaryService {

    @GET("/api/v1/dicservice/lookup")
    fun lookup(
        @Query("lang") lang: String,
        @Query("text") text: String,
        @Query("key") key: String = KEY,
    ): Call<DicResult>
}