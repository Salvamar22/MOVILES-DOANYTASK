package com.mejia.doanytask.network.dto

import com.mejia.doanytask.data.model.Event

class EventsResponse (
    val count: Int,
    val hastNext: Boolean,
    val hastPrev: Boolean,
    val events:List<Event>,
    val nextPage: String,
    val prevPage: String
)