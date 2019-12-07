package com.example.proyectochat.views


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.proyectochat.R
import com.example.proyectochat.interfaces.FragmentLauncher
import com.example.proyectochat.interfaces.Login
import com.example.proyectochat.presenters.PresenterLogin
import kotlinx.android.synthetic.main.fragment_view_login.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ViewLogin(private val launcher: FragmentLauncher) : Fragment(), Login.LoginView{

    lateinit var presenter: PresenterLogin

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        presenter = PresenterLogin(this)
        login_button.setOnClickListener {
            val email = login_email.text.toString()
            val password = login_password.text.toString()
            presenter.loginUser(email, password)
        }

        login_register_button.setOnClickListener {
            this.loadRegisterView()
        }

    }


    override fun loadDashboardView(token: String) {
        launcher.launchDashboard(token)
    }

    override fun loadRegisterView() {
        launcher.launchRegister()
    }

    override fun showError(error: String) {
        Toast.makeText(this.context, error, Toast.LENGTH_LONG).show()
    }


}
