package com.manuelmadriz.dummydictionary.repository

import android.util.Log
import com.mejia.doanytask.network.AllService
import com.mejia.doanytask.network.ApiResponse
import com.mejia.doanytask.network.dto.LoginRequest
import okio.IOException
import retrofit2.HttpException

class LoginRepository(private val api: AllService) {

    suspend fun login(username: String, password: String): ApiResponse<String> {
        try {
            val response = api.login(LoginRequest(username, password))
            Log.d("Creation","I just wanna be happy");
            return ApiResponse.Success(response.token)

        } catch (e: HttpException) {
            if (e.code() == 400) {
                return ApiResponse.ErrorWithMessage(e.response()?.body().toString())
            }
            if (e.code() == 404) {
                Log.d("Creation","User not found");
                return ApiResponse.ErrorWithMessage(e.response()?.body().toString())
            }
            if (e.code() == 401) {
                Log.d("Creation","Invalid password");
                return ApiResponse.ErrorWithMessage(e.response()?.body().toString())
            }
        } catch (e: IOException) {
            return ApiResponse.Error(e)
        }
        return ApiResponse.Success("")
    }
}