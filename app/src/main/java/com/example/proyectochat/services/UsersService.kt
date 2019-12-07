package com.example.proyectochat.services

import com.example.proyectochat.responses.GetAllUsersResponse
import retrofit2.Call
import retrofit2.http.GET

interface UsersService {
    @GET("/users")
    fun getAllUsers(): Call<GetAllUsersResponse>
}