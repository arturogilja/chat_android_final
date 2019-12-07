package com.example.proyectochat.presenters

import com.example.proyectochat.interactors.InteractorLogin
import com.example.proyectochat.interfaces.Login

class PresenterLogin(private val view: Login.LoginView) : Login.LoginPresenter {
    private val interactor = InteractorLogin(this)

    override fun loginUser(email: String, password: String) {
        interactor.loginUser(email, password)
    }

    override fun loadDashboardView(token: String) {
        view.loadDashboardView(token)
    }

    override fun showError(error: String) {
        view.showError(error)
    }
}