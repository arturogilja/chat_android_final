package com.example.proyectochat.interactors

import android.util.Log
import com.example.proyectochat.RetrofitClient
import com.example.proyectochat.interfaces.Register
import com.example.proyectochat.responses.RegisterResponse
import com.example.proyectochat.services.RegisterService
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class InteractorRegister(var presenter : Register.RegisterPresenter) : Register.RegisterInteractor {
    private val retrofitClientRegister = RetrofitClient.getInstance()
    private val registerService = retrofitClientRegister.createService(RegisterService::class.java)

    override fun registerUser(
        email: String,
        password: String,
        username: String,
        name: String,
        lastname: String,
        phone: String
    ) {

        registerService
            .registerNewUser(email, password, username, name, lastname, phone)
            .enqueue(object: Callback,
                retrofit2.Callback<RegisterResponse>{
                override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
                    if(response.code() == 200) {
                        presenter.loadLoginView()

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

                override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                    showError("NO HUBO COMUNICACION CON LA API")
                }
            })
    }

    private fun showError(error: String){
        presenter.showError(error)
    }
}