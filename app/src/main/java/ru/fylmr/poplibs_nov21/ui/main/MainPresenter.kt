package ru.fylmr.poplibs_nov21.ui.main

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.fylmr.poplibs_nov21.screens.AppScreens
import ru.fylmr.poplibs_nov21.ui.users.UsersFragment

class MainPresenter(
    private val router: Router,
) : MvpPresenter<MainView>() {

    private var appScreens: AppScreens? = AppScreens()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        appScreens?.usersScreen(UsersFragment())?.let { router.replaceScreen(it) }
    }

    fun backPressed() {
        appScreens = null
        router.exit()
    }
}