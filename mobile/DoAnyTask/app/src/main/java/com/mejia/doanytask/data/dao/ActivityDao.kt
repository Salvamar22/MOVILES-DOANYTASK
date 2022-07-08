package com.mejia.doanytask.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mejia.doanytask.data.model.Activity

@Dao
interface ActivityDao {

    @Query("SELECT * FROM activity_table")
    fun getAllActivities(): LiveData<List<Activity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertActivity(activity: Activity)

    /*@Update
    suspend fun updateActivity(activity: Activity)

    @Delete
    suspend fun deleteActivity(activity: Activity)*/
}