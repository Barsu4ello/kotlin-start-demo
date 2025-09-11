package lesson10.photoTask

interface RepositoryContract {
    fun getMoreData(tag: String): String
}