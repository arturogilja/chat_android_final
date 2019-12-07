package com.example.proyectochat.interfaces

import com.example.proyectochat.responses.Message


interface Messages {
    interface MessagesView{
        fun showMessagePosted(message: String)
        fun loadDashboardView(token: String)
        fun inflateListOfMessages(messages: ArrayList<Message>)
        fun showError(error: String)
        fun cleanTextinput()
    }

    interface MessagesPresenter{
        fun showMessagePosted(message: String)
        fun loadDashboardView(token: String)
        fun showAllMessages(messages: ArrayList<Message>)
        fun postMessage(token: String, toID: String, message: String)
        fun getMessages(token: String, toID: String)
        fun getLastMessage(token: String, toID: String)
        fun showError(error: String)
    }

    interface MessagesInteractor{
        fun postMessage(token: String, toID: String, message: String)
        fun getMessages(token: String, toID: String)
        fun getLastMessage(token: String, toID: String)
    }
}