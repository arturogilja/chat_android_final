package com.example.proyectochat.views


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.proyectochat.R
import com.example.proyectochat.interfaces.FragmentLauncher
import com.example.proyectochat.interfaces.Register
import com.example.proyectochat.presenters.PresenterRegister
import kotlinx.android.synthetic.main.fragment_view_register.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ViewRegister(private val launcher: FragmentLauncher) : Fragment(), Register.RegisterView {

    lateinit var presenter : PresenterRegister

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = PresenterRegister(this)
        register_button.setOnClickListener {
            val email = register_email.text.toString()
            val password = register_password.text.toString()
            val username = register_username.text.toString()
            val name = register_name.text.toString()
            val lastname = register_lastname.text.toString()
            val phone = register_phone.text.toString()
            presenter.registerUser(email, password, username, name, lastname, phone)
        }

        register_login_button.setOnClickListener {
            this.loadLoginView()
        }

    }

    override fun registerUser(
        email: String,
        password: String,
        username: String,
        name: String,
        lastname: String,
        phone: String
    ) {
        presenter.registerUser(email, password, username, name, lastname, phone)
    }

    override fun loadLoginView() {
        launcher.launchLogin()
    }

    override fun showError(error: String) {
        Toast.makeText(this.context, error, Toast.LENGTH_LONG).show()
    }

}
