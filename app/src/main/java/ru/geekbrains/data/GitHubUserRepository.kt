package ru.geekbrains.data

import io.reactivex.rxjava3.core.Single
import ru.geekbrains.data.repos.GitHubRepos

interface GitHubUserRepository {

    fun getUsers(): Single<List<GitHubUser>>

    fun getUserByLogin(userId: String): Single<GitHubUser>

    fun getReposByLogin(userId: String): Single<List<GitHubRepos>>

}