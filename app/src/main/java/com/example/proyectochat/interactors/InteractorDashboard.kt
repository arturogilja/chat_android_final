package com.example.proyectochat.interactors

import com.example.proyectochat.RetrofitClient
import com.example.proyectochat.interfaces.Dashboard
import com.example.proyectochat.responses.GetAllUsersResponse
import com.example.proyectochat.services.UsersService
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class InteractorDashboard(var presenter: Dashboard.DashboardPresenter) : Dashboard.DashboardInteractor {
    private val retrofitClient = RetrofitClient.getInstance()
    private val usersService = retrofitClient.createService(UsersService::class.java)
    override fun getUsers() {
        usersService.getAllUsers().enqueue(object : Callback, retrofit2.Callback<GetAllUsersResponse>{
            override fun onResponse(call: Call<GetAllUsersResponse>, response: Response<GetAllUsersResponse>) {
                if(response.code() == 200) {
                    presenter.showListOfUsers(response.body()!!.users)
                } else {
                    var jsonError: JSONObject? = null
                    try {
                        jsonError = JSONObject(response.errorBody()!!.string())
                        val error = jsonError.getString("error")
                        showError(error)
                    } catch (e: JSONException) {
                        showError("I FUCKED UP SOMEHOW")
                    }
                }
            }

            override fun onFailure(call: Call<GetAllUsersResponse>, t: Throwable) {
                showError("NO HUBO COMUNICACION CON LA API")
            }
        })

    }

    private fun showError(error: String){
        presenter.showError(error)
    }
}