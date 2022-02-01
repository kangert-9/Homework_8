package ru.geekbrains.mvpuser.recycler

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.geekbrains.data.GitHubUser
import ru.geekbrains.data.repos.GitHubRepos
import ru.geekbrains.databinding.ViewUserBinding

class RepoViewHolder(private val viewBinding: ViewUserBinding): RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(repo: GitHubRepos) {
        viewBinding.userLogin.text = repo.name
    }
}