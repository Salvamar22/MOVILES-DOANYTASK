package com.manuelmadriz.dummydictionary.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mejia.doanytask.data.DoAnyTaskDatabase
import com.mejia.doanytask.data.dao.ActivityDao
import com.mejia.doanytask.data.model.Activity
import com.mejia.doanytask.network.AllService
import com.mejia.doanytask.network.ApiResponse
import okio.IOException
import retrofit2.HttpException

class ActivityRepository(database: DoAnyTaskDatabase, private val api: AllService) {
    private var activityDao = database.activityDao();

    suspend fun getAllActivities(): ApiResponse<LiveData<List<Activity>>> {
        return try {
            val response = api.getAllActivities()

            if (response.count > 0) {
                for(i in 0..response.count){
                    activityDao.insertActivity(response.activities[i])
                }
            }
            ApiResponse.Success(data = activityDao.getAllActivities())
        } catch (e: HttpException) {
            ApiResponse.Error(exception = e)
        } catch (e: IOException) {
            ApiResponse.Error(exception = e)
        }
    }
}