package com.mejia.doanytask.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "event_table")
data class Event(
    @PrimaryKey
    @ColumnInfo(name = "_id") val _id: String,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "date") var date: String,
    @ColumnInfo(name = "hour") var hour: String,
    @ColumnInfo(name = "description") var description: String,
    @ColumnInfo(name = "use_id") val user_id: String
)