package ru.geekbrains.mvpuser

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState
import ru.geekbrains.data.GitHubUser
import ru.geekbrains.data.repos.GitHubRepos

interface UserView : MvpView {

    /**
     * Показывает информацию о пользователе.
     * @param user пользователь
     */
    @SingleState
    fun showRepos(repos: List<GitHubRepos>)

}