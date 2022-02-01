package ru.geekbrains.mvpuser.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.geekbrains.data.repos.GitHubRepos
import ru.geekbrains.databinding.ViewUserBinding

class RepoAdapter: ListAdapter<GitHubRepos, RepoViewHolder>(UserDiffRepo()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val itemBinding = ViewUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return RepoViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) =
        holder.bind(getItem(position))

}