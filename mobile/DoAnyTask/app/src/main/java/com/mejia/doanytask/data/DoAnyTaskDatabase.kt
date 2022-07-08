package com.mejia.doanytask.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mejia.doanytask.data.model.Activity
import com.mejia.doanytask.data.dao.ActivityDao
import com.mejia.doanytask.data.dao.EventDao
import com.mejia.doanytask.data.dao.TaskDao
import com.mejia.doanytask.data.model.Event
import com.mejia.doanytask.data.model.Task

@Database(
    entities = [Activity::class, Task::class, Event::class],
    version = 1,
    exportSchema = false
)
abstract class DoAnyTaskDatabase : RoomDatabase() {
    abstract fun activityDao(): ActivityDao
    abstract fun eventDao(): EventDao
    abstract fun taskDao(): TaskDao

    companion object {
        @Volatile
        private var INSTANCE: DoAnyTaskDatabase? = null

        fun getInstance(context: Context): DoAnyTaskDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DoAnyTaskDatabase::class.java,
                    "do_any_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}