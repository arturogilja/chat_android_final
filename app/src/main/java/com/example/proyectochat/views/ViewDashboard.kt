package com.example.proyectochat.views


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager

import com.example.proyectochat.R
import com.example.proyectochat.UsersAdapter
import com.example.proyectochat.interfaces.Dashboard
import com.example.proyectochat.interfaces.FragmentLauncher
import com.example.proyectochat.presenters.PresenterDashboard
import com.example.proyectochat.responses.User
import kotlinx.android.synthetic.main.fragment_view_dashboard.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ViewDashboard(private val launcher: FragmentLauncher, private val token: String) : Fragment(), Dashboard.DashboardView {

    lateinit var presenter: Dashboard.DashboardPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_view_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = PresenterDashboard(this)
        presenter.getUsers()
        dashboard_logout_button.setOnClickListener {
            this.loadLoginView()
        }
    }

    override fun inflateListOfUsers(users: ArrayList<User>) {
        dashboard_users_recycler.layoutManager = GridLayoutManager(context, 1)
        dashboard_users_recycler.adapter = UsersAdapter(users, token, this)
    }

    override fun loadMessagesView(token: String, toID: String) {
        launcher.launchMessages(token, toID)
    }

    override fun loadLoginView() {
        launcher.launchLogin()
    }

    override fun showError(error: String) {
        Toast.makeText(this.context, error, Toast.LENGTH_LONG).show()
    }


}
