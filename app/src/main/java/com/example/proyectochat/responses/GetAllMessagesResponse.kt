package com.example.proyectochat.responses

import com.google.gson.annotations.SerializedName

class GetAllMessagesResponse (
    @field:SerializedName("messages")
    val messages : ArrayList<Message>
)