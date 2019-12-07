package com.example.proyectochat.interactors

import com.example.proyectochat.RetrofitClient
import com.example.proyectochat.interfaces.Messages
import com.example.proyectochat.responses.GetAllMessagesResponse
import com.example.proyectochat.responses.Message
import com.example.proyectochat.responses.PostMessageResponse
import com.example.proyectochat.services.MessagesService
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class InteractorMessages(var presenter: Messages.MessagesPresenter) : Messages.MessagesInteractor {
    private val retrofitClient = RetrofitClient.getInstance()
    private val messagesService = retrofitClient.createService(MessagesService::class.java)

    override fun postMessage(token: String, toID: String, message: String) {
        messagesService.postMessage(token, toID, message).enqueue(object : Callback, retrofit2.Callback<PostMessageResponse>{
            override fun onResponse(call: Call<PostMessageResponse>, response: Response<PostMessageResponse>) {
                if(response.code() == 200){
                    presenter.showMessagePosted(message)
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

            override fun onFailure(call: Call<PostMessageResponse>, t: Throwable) {
                showError("NO HUBO COMUNICACION CON LA API")
            }
        })

    }

    override fun getMessages(token: String, toID: String) {
        messagesService.getMessages(token, toID).enqueue(object : Callback, retrofit2.Callback<GetAllMessagesResponse>{
            override fun onResponse(call: Call<GetAllMessagesResponse>, response: Response<GetAllMessagesResponse>) {
                if(response.code() == 200){
                    presenter.showAllMessages(response.body()!!.messages)
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

            override fun onFailure(call: Call<GetAllMessagesResponse>, t: Throwable) {
                showError("NO HUBO COMUNICACION CON LA API")
            }
        })
    }

    override fun getLastMessage(token: String, toID: String) {
        messagesService.getLastMessage(token, toID).enqueue(object : Callback, retrofit2.Callback<Message>{
            override fun onResponse(call: Call<Message>, response: Response<Message>) {
                if(response.code() == 200) {

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

            override fun onFailure(call: Call<Message>, t: Throwable) {
                showError("NO HUBO COMUNICACION CON LA API")
            }
        })
    }

    private fun showError(error: String){
        presenter.showError(error)
    }

}