package ru.geekbrains.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.geekbrains.data.repos.DBRepoStorage
import ru.geekbrains.data.room.DBStorage
import javax.inject.Singleton

@Module
class RoomModule {

    @Singleton
    @Provides
    fun providesRoomModule(app: Context): DBStorage {
        return Room.databaseBuilder(app, DBStorage::class.java, "github.db")
            .build()
    }

    @Singleton
    @Provides
    fun providesRoomModuleRepo(app: Context): DBRepoStorage {
        return Room.databaseBuilder(app, DBRepoStorage::class.java, "githubrepo.db")
            .build()
    }
}