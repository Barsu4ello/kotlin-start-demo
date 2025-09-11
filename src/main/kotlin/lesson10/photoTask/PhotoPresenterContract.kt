package lesson10.photoTask

interface PhotoPresenterContract {
    fun registerView(view: PhotoViewContract)
    fun dataReady(s: String)
    fun getMoreData(tag: String)
    fun registerRepository(repository: RepositoryContract)
}

class Presenter : PhotoPresenterContract {

    private lateinit var view: PhotoViewContract
    private lateinit var repository: RepositoryContract
    override fun registerView(view: PhotoViewContract) {
        this.view = view
    }

    override fun dataReady(s: String) {
        if (s == "error") {
            view.showError(Throwable("ERROR"))
        } else {
            view.newData(s)
        }
    }

    override fun getMoreData(tag: String) {
        repository.getMoreData(tag)
        view.newData("world:$tag")
    }

    override fun registerRepository(repository: RepositoryContract) {
        this.repository = repository
    }
}
