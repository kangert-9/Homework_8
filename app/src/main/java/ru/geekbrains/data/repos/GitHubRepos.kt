package ru.geekbrains.data.repos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "GitHubReposTable")
data class GitHubRepos(
        @PrimaryKey
        @ColumnInfo
        val id: String,
        @ColumnInfo
        val name: String? = null,
        @ColumnInfo
        val login: String? = null,
    )