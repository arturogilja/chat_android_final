package com.example.proyectochat.interfaces


interface Register {
    interface RegisterView{
        fun registerUser(email:String, password: String, username: String, name: String, lastname: String, phone: String)
        fun loadLoginView()
        fun showError(error: String)
    }

    interface RegisterPresenter{
        fun registerUser(email:String, password: String, username: String, name: String, lastname: String, phone: String)
        fun showError(error: String)
        fun loadLoginView()
    }

    interface RegisterInteractor{
        fun registerUser(email:String, password: String, username: String, name: String, lastname: String, phone: String)
    }
}