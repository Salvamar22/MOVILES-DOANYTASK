package com.mejia.doanytask.network.dto

import com.mejia.doanytask.data.model.Activity

data class CreateTaskRequest (
    var name: String,
    var date: String,
    var hour: String,
    var data: String,
    val user_id: String
)