package com.example.proyectochat.interfaces

interface Login {
    interface LoginView{
        fun loadDashboardView(token: String)
        fun loadRegisterView()
        fun showError(error: String)
    }
    interface LoginPresenter{
        fun loginUser(email: String, password: String)
        fun showError(error: String)
        fun loadDashboardView(token: String)
    }

    interface LoginInteractor{
        fun loginUser(email: String, password: String)
    }
}