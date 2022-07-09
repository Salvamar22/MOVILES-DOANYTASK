package com.mejia.doanytask.network.dto

data class RegisterRequest (
    val name: String,
    val username: String,
    val email: String,
    val lastName: String,
    val dateofbirth: String,
    val password: String
)