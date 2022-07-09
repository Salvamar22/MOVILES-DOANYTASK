package com.mejia.doanytask.network.dto

import com.mejia.doanytask.data.model.Activity

data class CreateActivityRequest (
    var name: String,
    var priority: String?,
    var ubication: String,
    var date: String,
    var hour: String,
    var description: String,
    val user_id: String?,
    var event_id: String?
)