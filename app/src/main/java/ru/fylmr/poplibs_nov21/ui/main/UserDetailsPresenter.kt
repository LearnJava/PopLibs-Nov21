package ru.fylmr.poplibs_nov21.ui.main

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.fylmr.poplibs_nov21.App
import ru.fylmr.poplibs_nov21.model.GithubUserModel

class UserDetailsPresenter(private val router: Router,) : MvpPresenter<IUserDetailsView>() {


    var user: GithubUserModel? = null

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
    }

    fun backPressed(): Boolean {
        App.instance.router.exit()
        return true
    }
}