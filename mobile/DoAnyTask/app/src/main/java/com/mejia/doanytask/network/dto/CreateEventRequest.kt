package com.mejia.doanytask.network.dto

import com.mejia.doanytask.data.model.Activity

data class CreateEventRequest (
    var name: String,
    var date: String,
    var hour: String,
    var data: String,
    val user_id: String
)