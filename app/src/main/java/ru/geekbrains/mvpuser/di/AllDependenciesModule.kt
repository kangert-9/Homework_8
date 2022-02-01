package ru.geekbrains.mvpuser.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.geekbrains.data.GitHubUserRepository
import ru.geekbrains.data.GitHubUserRepositoryImpl
import ru.geekbrains.data.repos.DBRepoStorage
import ru.geekbrains.data.retrofit.GitHubApi
import ru.geekbrains.data.room.DBStorage
import javax.inject.Named


@Module
class AllDependenciesModule {
    @FragmentScope
    @Provides
    fun provideRepository(
        @Named("prod") api: GitHubApi,
        dbStorage: DBStorage,
        dbRepoStorage: DBRepoStorage
    ): GitHubUserRepository {
        return GitHubUserRepositoryImpl(api, dbStorage, dbRepoStorage)
    }
}