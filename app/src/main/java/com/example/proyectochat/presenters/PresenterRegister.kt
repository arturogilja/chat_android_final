package com.example.proyectochat.presenters

import com.example.proyectochat.interactors.InteractorRegister
import com.example.proyectochat.interfaces.Register

class PresenterRegister(val view: Register.RegisterView) : Register.RegisterPresenter {
    private val interactor = InteractorRegister(this)
    override fun registerUser(
        email: String,
        password: String,
        username: String,
        name: String,
        lastname: String,
        phone: String
    ) {
        interactor.registerUser(email, password, username, name, lastname, phone)
    }

    override fun showError(error: String) {
        view.showError(error)
    }

    override fun loadLoginView() {
        view.loadLoginView()
    }
}