package com.mejia.doanytask.network.dto

import com.mejia.doanytask.data.model.Task

data class TasksResponse (
    val count: Int,
    val hastNext: Boolean,
    val hastPrev: Boolean,
    val tasks:List<Task>,
    val nextPage: String,
    val prevPage: String
)