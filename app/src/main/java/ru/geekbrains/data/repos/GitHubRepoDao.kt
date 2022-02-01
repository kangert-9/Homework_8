package ru.geekbrains.data.repos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import io.reactivex.rxjava3.core.Single

@Dao
interface GitHubRepoDao {

    @Query("SELECT * FROM GitHubReposTable WHERE login LIKE :login")
    fun getReposByLogin(login: String): Single<List<GitHubRepos>>

    @Insert(onConflict = REPLACE)
    fun saveRepo(repos: List<GitHubRepos>)
}