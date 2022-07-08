package com.mejia.doanytask.network.dto

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("name")
    val name: String,
    val password: String
)