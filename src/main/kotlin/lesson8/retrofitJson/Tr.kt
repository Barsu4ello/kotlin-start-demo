package lesson8.retrofitJson

data class Tr(
    val asp: String,
    val fr: Int,
    val gen: String,
    val mean: List<Mean>,
    val pos: String,
    val syn: List<Syn>,
    val text: String
)