package com.example.proyectochat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectochat.interfaces.Dashboard
import com.example.proyectochat.responses.User

class UsersAdapter(private val users: ArrayList<User>, private val token: String, private val view: Dashboard.DashboardView) : RecyclerView.Adapter<UsersAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.element_user, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val username = users[position].username
        val id = users[position].id

        holder.username.text = username

        holder.username.setOnClickListener {
            view.loadMessagesView(token, id)
        }
    }

    override fun getItemCount(): Int {
        return users.size
    }

    inner class ViewHolder(userView: View): RecyclerView.ViewHolder(userView){
        internal var username : TextView = userView.findViewById(R.id.element_username)
    }
}