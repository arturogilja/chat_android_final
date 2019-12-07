package com.example.proyectochat.presenters

import com.example.proyectochat.interactors.InteractorDashboard
import com.example.proyectochat.interfaces.Dashboard
import com.example.proyectochat.responses.User

class PresenterDashboard(private val view: Dashboard.DashboardView): Dashboard.DashboardPresenter {
    private val interactor = InteractorDashboard(this)
    override fun getUsers() {
        interactor.getUsers()
    }

    override fun showListOfUsers(users: ArrayList<User>) {
        view.inflateListOfUsers(users)
    }

    override fun showError(error: String) {
        view.showError(error)
    }
}