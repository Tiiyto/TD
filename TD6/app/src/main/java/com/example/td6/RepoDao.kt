package com.example.td6

import androidx.room.*
import com.example.td6.models.Repo
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

@Dao
interface RepoDao {
    @Query("SELECT * FROM Repo")
    fun getRepos(): Observable<List<Repo>>

    @Query("SELECT * FROM Repo WHERE id = :id")
    fun getReposByID(id: Int): Observable<List<Repo>>

    @Delete
    fun deleteRepo(repo: Repo): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdateRepo(repo: Repo): Completable

}