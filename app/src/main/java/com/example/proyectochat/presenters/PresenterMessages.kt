package com.example.proyectochat.presenters

import com.example.proyectochat.interactors.InteractorMessages
import com.example.proyectochat.interfaces.Messages
import com.example.proyectochat.responses.Message

class PresenterMessages(val view: Messages.MessagesView): Messages.MessagesPresenter {
    private val interactor = InteractorMessages(this)

    override fun loadDashboardView(token: String) {
        view.loadDashboardView(token)
    }

    override fun showMessagePosted(message: String) {
        view.showMessagePosted(message)
    }

    override fun showAllMessages(messages: ArrayList<Message>){
        view.inflateListOfMessages(messages)
    }

    override fun showError(error: String) {
        view.showError(error)
    }

    override fun postMessage(token: String, toID: String, message: String) {
        interactor.postMessage(token, toID, message)
        view.cleanTextinput()
    }

    override fun getMessages(token: String, toID: String) {
        interactor.getMessages(token, toID)

    }

    override fun getLastMessage(token: String, toID: String) {
        interactor.getLastMessage(token, toID)
    }
}