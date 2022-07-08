package com.mejia.doanytask.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "activity_table")
data class Activity (
    @PrimaryKey
    val _id: String,
    var name: String,
    var priority: String?,
    var ubication: String,
    var date: String,
    var hour: String,
    var description: String,
    val user_id: String?,
    var event_id: String?
)