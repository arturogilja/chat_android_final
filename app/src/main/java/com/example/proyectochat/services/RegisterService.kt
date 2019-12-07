package com.example.proyectochat.services

import com.example.proyectochat.responses.RegisterResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface RegisterService {
    @POST("/auth/register/")
    @FormUrlEncoded
    fun registerNewUser(
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("username") username: String,
        @Field("name") name: String,
        @Field("lastname") lastname: String,
        @Field("phone") phone: String
    ): Call<RegisterResponse>
}