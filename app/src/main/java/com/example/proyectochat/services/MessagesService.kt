package com.example.proyectochat.services

import com.example.proyectochat.responses.GetAllMessagesResponse
import com.example.proyectochat.responses.LoginResponse
import com.example.proyectochat.responses.Message
import com.example.proyectochat.responses.PostMessageResponse
import retrofit2.Call
import retrofit2.http.*

interface MessagesService {
    @POST("/messages")
    @FormUrlEncoded
    fun postMessage(
        @Header("authorization") token: String,
        @Field("toID") username: String,
        @Field("message") password: String
    ): Call<PostMessageResponse>

    @GET("/messages/{toID}")
    fun getMessages(
        @Header("authorization") token: String,
        @Path("toID") toID: String
    ): Call<GetAllMessagesResponse>

    @GET("/messages/{toID}/last")
    fun getLastMessage(
        @Header("authorization") token: String,
        @Path("toID") toID: String
    ): Call<Message>

}