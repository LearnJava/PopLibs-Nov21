package ru.fylmr.poplibs_nov21.ui.users

import android.util.Log
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.FragmentScreen
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import moxy.MvpPresenter
import ru.fylmr.poplibs_nov21.domain.GithubUsersRepository
import ru.fylmr.poplibs_nov21.model.GithubUserModel
import ru.fylmr.poplibs_nov21.ui.base.IListPresenter
import ru.fylmr.poplibs_nov21.ui.main.UserProfileFragment

class UsersPresenter(
    private val router: Router,
    private val usersRepository: GithubUsersRepository,
) : MvpPresenter<UsersView>() {

    val usersListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        loadData()

        usersListPresenter.itemClickListener = { itemView ->
            val user = usersListPresenter.users[itemView.pos]
            router.navigateTo(FragmentScreen { UserProfileFragment.newInstance(user) })
        }
    }

    private val observer = object
        : Observer<List<GithubUserModel>> {
        override fun onSubscribe(d: Disposable) {
            Log.d("RxJava", "Subscribed")
        }

        override fun onNext(users: List<GithubUserModel>) {
            usersListPresenter.users.addAll(users)
            viewState.updateList()
        }

        override fun onError(e: Throwable) {
            Log.e("RxJava", e.stackTraceToString())
        }

        override fun onComplete() {
            Log.d("RxJava", "Success")
        }

    }

    private fun loadData() {
        usersRepository.getUsers().subscribe(observer)
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    class UsersListPresenter : IListPresenter<IUserItemView> {

        val users = mutableListOf<GithubUserModel>()

        override var itemClickListener: ((IUserItemView) -> Unit)? = null

        override fun getCount() = users.size

        override fun bindView(view: IUserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }
    }
}