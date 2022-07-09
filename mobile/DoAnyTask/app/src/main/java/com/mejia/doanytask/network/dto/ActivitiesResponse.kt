package com.mejia.doanytask.network.dto

import com.mejia.doanytask.data.model.Activity

data class ActivitiesResponse (
    val count: Int,
    val hastNext: Boolean,
    val hastPrev: Boolean,
    val data:List<Activity>,
    val nextPage: String,
    val prevPage: String
)