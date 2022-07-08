package com.mejia.doanytask

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.manuelmadriz.dummydictionary.repository.ActivityRepository
import com.manuelmadriz.dummydictionary.repository.EventRepository
import com.manuelmadriz.dummydictionary.repository.LoginRepository
import com.manuelmadriz.dummydictionary.repository.TaskRepository
import com.mejia.doanytask.data.DoAnyTaskDatabase
import com.mejia.doanytask.network.RetrofitInstance


class DoAnyTaskApplication : Application() {
    private val prefs: SharedPreferences by lazy {
        getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE)
    }

    val dataBase by lazy {
        DoAnyTaskDatabase.getInstance(this)
    }

    private fun getAPIService() = with(RetrofitInstance) {
        setToken(getToken())
        getAllServices()
    }

    fun getActivityRepository() = with(dataBase) {
        ActivityRepository(dataBase, getAPIService())
    }

    fun getTaskRepository() = with(dataBase) {
        TaskRepository(dataBase, getAPIService())
    }

    fun getEventRepository() = with(dataBase) {
        EventRepository(dataBase, getAPIService())
    }

    fun getLoginRepository() =
        LoginRepository(getAPIService())

    private fun getToken(): String = prefs.getString(USER_TOKEN, "")!!

    fun isUserLogin() = getToken() != ""

    fun saveAuthToken( token: String) {
        val editor = prefs.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }

    companion object {
        const val USER_TOKEN = "user_token"
    }
}