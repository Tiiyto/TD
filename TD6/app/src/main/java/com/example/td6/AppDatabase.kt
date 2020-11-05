package com.example.td6

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.td6.models.Repo


@Database(entities = [Repo::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun repoDao(): RepoDao
}