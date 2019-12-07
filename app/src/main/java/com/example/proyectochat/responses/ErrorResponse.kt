package com.example.proyectochat.responses

import com.google.gson.annotations.SerializedName

class ErrorResponse (
    @field:SerializedName("error")
    val error : String
)