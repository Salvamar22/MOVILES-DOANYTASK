package com.manuelmadriz.dummydictionary.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mejia.doanytask.data.DoAnyTaskDatabase
import com.mejia.doanytask.data.dao.EventDao
import com.mejia.doanytask.data.model.Event
import com.mejia.doanytask.network.AllService
import com.mejia.doanytask.network.ApiResponse
import okio.IOException
import retrofit2.HttpException

class EventRepository(database: DoAnyTaskDatabase, private val api: AllService) {
    private var eventDao = database.eventDao();

    suspend fun getAllEvents(): ApiResponse<LiveData<List<Event>>> {
        return try {
            val response = api.getAllEvents()

            if (response.count > 0) {
                for(i in 0..response.count){
                    eventDao.insertEvent(response.events[i])
                }
            }
            ApiResponse.Success(data = eventDao.getAllEvents())
        } catch (e: HttpException) {
            ApiResponse.Error(exception = e)
        } catch (e: IOException) {
            ApiResponse.Error(exception = e)
        }
    }
}