package ru.geekbrains.data

import io.reactivex.rxjava3.core.Single
import ru.geekbrains.data.repos.DBRepoStorage
import ru.geekbrains.data.repos.GitHubRepos
import ru.geekbrains.data.retrofit.GitHubApi
import ru.geekbrains.data.room.DBStorage
import javax.inject.Inject

class GitHubUserRepositoryImpl
@Inject constructor(
    private val gitHubApi: GitHubApi,
    private val roomDb: DBStorage,
    private val repoDb: DBRepoStorage
) : GitHubUserRepository {

    override fun getUsers(): Single<List<GitHubUser>> {
        return roomDb.getGitHubUserDao().getUsers()
            .flatMap {
                if (it.isEmpty()) {
                    gitHubApi.fetchUsers()
                        .map { resultFromServer ->
                            roomDb.getGitHubUserDao().saveUser(resultFromServer)
                            resultFromServer
                        }
                } else {
                    Single.just(it)
                }
            }
    }

    override fun getUserByLogin(userId: String): Single<GitHubUser> {
        return roomDb.getGitHubUserDao().getUserByLogin(userId).flatMap {
            if (it.name == null) {
                gitHubApi.fetchUserByLogin(userId).map { resultFromServer ->
                    roomDb.getGitHubUserDao().saveUser(resultFromServer)
                    resultFromServer
                }
            } else {
                Single.just(it)
            }
        }
    }

    override fun getReposByLogin(userId: String): Single<List<GitHubRepos>>{
        return repoDb.getGitHubRepoDao().getReposByLogin(userId)
            .flatMap {
                if (it.isEmpty()) {
                    gitHubApi.fetchUserRepositories(userId)
                        .map { resultFromServer ->
                            repoDb.getGitHubRepoDao().saveRepo(resultFromServer)
                            resultFromServer
                        }
                } else {
                    Single.just(it)
                }
            }
    }
}