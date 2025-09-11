package lesson8.retrofitJson

data class DicResultFromJson(
    val code: Int,
    val def: List<Def>,
    val head: Head,
    val nmt_code: Int
)