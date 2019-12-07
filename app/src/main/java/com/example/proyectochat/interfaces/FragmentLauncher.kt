package com.example.proyectochat.interfaces

interface FragmentLauncher {
    fun launchRegister()
    fun launchLogin()
    fun launchDashboard(token: String)
    fun launchMessages(token: String, toID: String)
}