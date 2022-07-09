package com.mejia.doanytask.network

import com.mejia.doanytask.data.model.Activity
import com.mejia.doanytask.data.model.Event
import com.mejia.doanytask.data.model.Task
import com.mejia.doanytask.network.dto.*
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AllService {
    @GET( "/tasks")
    suspend fun getAllTasks(): TasksResponse
    @POST("/tasks/create")
    suspend fun createTask(): Task

    @GET( "/events")
    suspend fun getAllEvents(): EventsResponse
    @POST("/events/create")
    suspend fun createEvent(): Event

    @GET( "/activities")
    suspend fun getAllActivities(): ActivitiesResponse
    @POST("/activities/create")
    suspend fun createActivity(): Activity

    @POST( "/auth/login")
    suspend fun login( @Body credentials: LoginRequest): LoginResponse
    @POST( "/auth/register")
    suspend fun register( @Body credentials: RegisterRequest): LoginResponse
}