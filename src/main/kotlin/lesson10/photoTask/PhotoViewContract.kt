package lesson10.photoTask

interface PhotoViewContract {
    fun showError(t: Throwable?)
    fun newData(s: String)
}
