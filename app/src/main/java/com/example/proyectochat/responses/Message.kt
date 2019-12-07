package com.example.proyectochat.responses

import com.google.gson.annotations.SerializedName

class Message (
    @field:SerializedName("id")
    val id: String,
    @field:SerializedName("fromID")
    val fromID: String,
    @field:SerializedName("toID")
    val toID: String,
    @field:SerializedName("message")
    val message: String,
    @field:SerializedName("sentDate")
    val sentDate: String,
    @field:SerializedName("sentByMe")
    val sentByMe: Boolean,
    @field:SerializedName("sentBy")
    val sentBy: String
)