package ru.geekbrains.mvpuser

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.geekbrains.App
import ru.geekbrains.R
import ru.geekbrains.data.GitHubUser
import ru.geekbrains.data.GitHubUserRepositoryImpl
import ru.geekbrains.data.repos.GitHubRepos
import ru.geekbrains.databinding.ViewUserBinding
import ru.geekbrains.databinding.ViewUsersBinding
import ru.geekbrains.mvpuser.recycler.RepoAdapter
import ru.geekbrains.recycler.UsersAdapter

class UserFragment: MvpAppCompatFragment(R.layout.view_users), UserView {

    private lateinit var viewBinding: ViewUserBinding

    private val userLogin: String by lazy {
        arguments?.getString(ARG_USER_LOGIN).orEmpty()
    }

    private val presenter: UserPresenter by moxyPresenter {
        UserPresenter(
            userLogin
        ).apply {
            App.instance.component.provideUserComponent().build().inject(this)
        }
    }

    private val usersAdapter = RepoAdapter()
    private lateinit var viewBinging: ViewUsersBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = ViewUserBinding.bind(view)
        viewBinging.usersRecycler.adapter = usersAdapter
    }

    override fun showRepos(repos: List<GitHubRepos>) {
        usersAdapter.submitList(repos)
    }

    companion object {
        private const val ARG_USER_LOGIN = "arg_user_login"

        fun newInstance(userId: String): Fragment =
            UserFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_USER_LOGIN, userId)
                }
            }
    }
}