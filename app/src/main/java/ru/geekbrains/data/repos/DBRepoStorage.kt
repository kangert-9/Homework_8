package ru.geekbrains.data.repos

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(exportSchema = false, entities = [GitHubRepos::class], version = 1)
abstract class DBRepoStorage: RoomDatabase() {

    abstract fun getGitHubRepoDao(): GitHubRepoDao

}