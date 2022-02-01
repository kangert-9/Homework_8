package ru.geekbrains.mvpuser.recycler

import androidx.recyclerview.widget.DiffUtil
import ru.geekbrains.data.repos.GitHubRepos

class UserDiffRepo : DiffUtil.ItemCallback<GitHubRepos>() {

    override fun areItemsTheSame(oldItem: GitHubRepos, newItem: GitHubRepos): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: GitHubRepos, newItem: GitHubRepos): Boolean {
        return oldItem == newItem
    }
}