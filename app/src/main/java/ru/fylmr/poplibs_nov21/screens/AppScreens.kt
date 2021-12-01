package ru.fylmr.poplibs_nov21.screens

import com.github.terrakok.cicerone.androidx.FragmentScreen
import moxy.MvpAppCompatFragment
import ru.fylmr.poplibs_nov21.ui.users.UsersFragment

class AppScreens() {

    fun usersScreen(myScreen: MvpAppCompatFragment) = FragmentScreen {
        myScreen
    }
}