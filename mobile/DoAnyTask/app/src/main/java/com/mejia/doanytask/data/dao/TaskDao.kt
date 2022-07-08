package com.mejia.doanytask.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mejia.doanytask.data.model.Task

@Dao
interface TaskDao {

    @Query("SELECT * FROM task_table")
    fun getAllTasks(): LiveData<List<Task>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task)

    /*@Update
    suspend fun updateTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)*/
}