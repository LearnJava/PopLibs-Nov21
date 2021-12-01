package ru.fylmr.poplibs_nov21.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.fylmr.poplibs_nov21.App
import ru.fylmr.poplibs_nov21.databinding.FragmentUserProfileBinding
import ru.fylmr.poplibs_nov21.model.GithubUserModel
import ru.fylmr.poplibs_nov21.ui.users.IBackButtonListener

class UserProfileFragment private constructor(): MvpAppCompatFragment(), IBackButtonListener,
    IUserDetailsView {
    companion object {

        const val USER_ARG = "User"

        fun newInstance(user: GithubUserModel): UserProfileFragment {

            val args = Bundle().apply { putParcelable(USER_ARG, user) }
            val fragment = UserProfileFragment()

            fragment.arguments = args
            return fragment
        }
    }

//=================================================
private val presenter by moxyPresenter { UserDetailsPresenter(App.instance.router) }

    private var _binding: FragmentUserProfileBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentUserProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun backPressed(): Boolean {
        presenter.backPressed()
        return true
    }
//=================================================

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    override fun init() {
        presenter.user = arguments?.getParcelable(USER_ARG)
        presenter.user?.login?.let { showUserLogin(it) }
    }

    override fun showUserLogin(login: String) {
        binding.userLogin.text = login
    }
}