package com.mejia.doanytask.network

import com.mejia.doanytask.network.dto.*
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AllService {
    @GET( "/tasks")
    suspend fun getAllTasks(): TasksResponse

    @GET( "/events")
    suspend fun getAllEvents(): EventsResponse

    @GET( "/activities")
    suspend fun getAllActivities(): ActivitiesResponse

    @POST( "/login")
    suspend fun login( @Body credentials: LoginRequest): LoginResponse
}