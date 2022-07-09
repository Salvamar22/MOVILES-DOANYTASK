package com.mejia.doanytask.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "activity_table")
data class Activity (
    @PrimaryKey
    @ColumnInfo(name = "_id") val _id: String,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "ubication") var ubication: String,
    @ColumnInfo(name = "description") var description: String,
    @ColumnInfo(name = "date") var date: String,
    @ColumnInfo(name = "hour") var hour: String,
    @ColumnInfo(name = "user_id") val user_id: String?,
    @ColumnInfo(name = "priority") var priority: String?,
    @ColumnInfo(name = "event_id") var event_id: String?
)