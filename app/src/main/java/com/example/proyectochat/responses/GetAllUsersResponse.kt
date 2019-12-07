package com.example.proyectochat.responses

import com.google.gson.annotations.SerializedName

class GetAllUsersResponse (
    @field:SerializedName("users")
    val users: ArrayList<User>
)