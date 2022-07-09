package com.mejia.doanytask.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mejia.doanytask.data.model.Event

@Dao
interface EventDao {

    @Query("SELECT * FROM event_table")
    fun getAllEvents(): LiveData<List<Event>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEvent(event: Event): Long

    /*@Update
    suspend fun updateEvent(event: Event)

    @Delete
    suspend fun deleteEvent(event: Event)*/
}