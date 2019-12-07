package com.example.proyectochat.interactors

import com.example.proyectochat.RetrofitClient
import com.example.proyectochat.interfaces.Login
import com.example.proyectochat.responses.LoginResponse
import com.example.proyectochat.services.LoginService
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class InteractorLogin(val presenter: Login.LoginPresenter) : Login.LoginInteractor {
    private val retrofitClient = RetrofitClient.getInstance()
    private val loginService = retrofitClient.createService(LoginService::class.java)
    override fun loginUser(email: String, password: String) {
        loginService.loginUser(email, password).enqueue(object: Callback, retrofit2.Callback<LoginResponse>{
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if(response.code() == 200){
                    presenter.loadDashboardView(response.body()!!.token)
                    return
                } else {
                    var jsonError : JSONObject? = null
                    try {
                        jsonError = JSONObject(response.errorBody()!!.string())
                        val error = jsonError.getString("error")
                        showError(error)
                    }catch (e: JSONException){
                        showError("I FUCKED UP SOMEHOW")
                    }
                }

            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                showError("NO HUBO COMUNICACION CON LA API")
            }
        })
    }

    private fun showError(error: String){
        presenter.showError(error)
    }
}