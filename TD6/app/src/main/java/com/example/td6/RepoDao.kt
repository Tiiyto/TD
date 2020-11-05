package com.example.td6

import androidx.room.*
import com.example.td6.models.Repo

@Dao
interface RepoDao {
    @Query("SELECT * FROM Repo")
    fun getRepos(): List<Repo>
    @Query("SELECT * FROM Repo WHERE id = :id")
    fun getReposByID(id: Int): List<Repo>
    @Delete
    fun deleteRepo(repo: Repo)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdateRepo(repo: Repo): Long

}