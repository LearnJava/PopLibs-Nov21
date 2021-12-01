package ru.fylmr.poplibs_nov21.ui.main

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface IUserDetailsView : MvpView {
    fun init()
    fun showUserLogin(login: String)
}