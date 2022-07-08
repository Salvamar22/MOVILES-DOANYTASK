package com.mejia.doanytask.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "event_table")
data class Event(
    @PrimaryKey
    val _id: String,
    var name: String,
    var date: String,
    var hour: String,
    var description: String,
    val user_id: String
)