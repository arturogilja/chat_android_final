package com.example.proyectochat.interfaces

import com.example.proyectochat.responses.User


interface Dashboard {
    interface DashboardView{
        fun loadMessagesView(token: String, toID: String)
        fun inflateListOfUsers(users : ArrayList<User>)
        fun showError(error: String)
        fun loadLoginView()
    }
    interface DashboardPresenter{
        fun getUsers()
        fun showListOfUsers(users : ArrayList<User>)
        fun showError(error: String)

    }
    interface DashboardInteractor{
        fun getUsers()
    }
}