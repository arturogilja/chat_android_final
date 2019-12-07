package com.example.proyectochat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.proyectochat.interfaces.FragmentLauncher
import com.example.proyectochat.responses.RegisterResponse
import com.example.proyectochat.services.RegisterService
import com.example.proyectochat.views.ViewDashboard
import com.example.proyectochat.views.ViewLogin
import com.example.proyectochat.views.ViewMessages
import com.example.proyectochat.views.ViewRegister
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity(), FragmentLauncher {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.supportActionBar!!.hide()
        launchLogin()
//        launchRegister()
    }


    override fun launchRegister() {
        val registerFragment = ViewRegister(this)
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment, registerFragment)
        fragmentTransaction.commit()
    }

    override fun launchMessages(token: String, toID: String) {
        val messagesFragment = ViewMessages(this, token, toID)
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment, messagesFragment)
        fragmentTransaction.commit()
    }

    override fun launchLogin() {
        val loginFragment = ViewLogin(this)
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment, loginFragment)
        fragmentTransaction.commit()
    }

    override fun launchDashboard(token: String) {
        val dashboardFragment = ViewDashboard(this, token)
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment, dashboardFragment)
        fragmentTransaction.commit()
    }
}
