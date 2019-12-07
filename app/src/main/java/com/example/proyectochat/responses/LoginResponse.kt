package com.example.proyectochat.responses

import com.google.gson.annotations.SerializedName

class LoginResponse (
    @field:SerializedName("token")
    val token: String,
    @field:SerializedName("user")
    val user: User
)