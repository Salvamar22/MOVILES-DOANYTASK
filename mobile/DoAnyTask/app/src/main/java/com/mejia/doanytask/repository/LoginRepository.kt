package com.manuelmadriz.dummydictionary.repository

import com.mejia.doanytask.network.AllService
import com.mejia.doanytask.network.ApiResponse
import com.mejia.doanytask.network.dto.LoginRequest
import okio.IOException
import retrofit2.HttpException

class LoginRepository(private val api: AllService) {

    suspend fun login(username: String, password: String): ApiResponse<String> {
        try {
            val response = api.login(LoginRequest(username, password))
            return ApiResponse.Success(response.token)

        } catch (e: HttpException) {
            if (e.code() == 400) {
                //TODO: falta convertir body a objeto kotlin
                return ApiResponse.ErrorWithMessage(e.response()?.body().toString())
            }
        } catch (e: IOException) {
            return ApiResponse.Error(e)
        }
        return ApiResponse.Success("Esperemos el login funcione")
    }
}