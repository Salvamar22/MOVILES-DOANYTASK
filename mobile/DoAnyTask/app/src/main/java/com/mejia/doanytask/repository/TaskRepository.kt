package com.manuelmadriz.dummydictionary.repository

import androidx.lifecycle.LiveData
import com.mejia.doanytask.data.DoAnyTaskDatabase
import com.mejia.doanytask.data.model.Task
import com.mejia.doanytask.network.AllService
import com.mejia.doanytask.network.ApiResponse
import okio.IOException
import retrofit2.HttpException

class TaskRepository(database: DoAnyTaskDatabase, private val api: AllService) {
    private var taskDao = database.taskDao();

    suspend fun getAlltasks(): ApiResponse<LiveData<List<Task>>> {
        return try {
            val response = api.getAllTasks()

            if (response.count > 0) {
                for(i in 0..response.count){
                    taskDao.insertTask(response.tasks[i])
                }
            }
            ApiResponse.Success(data = taskDao.getAllTasks())
        } catch (e: HttpException) {
            ApiResponse.Error(exception = e)
        } catch (e: IOException) {
            ApiResponse.Error(exception = e)
        }
    }
}