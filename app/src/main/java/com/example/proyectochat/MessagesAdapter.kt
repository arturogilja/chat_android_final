package com.example.proyectochat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectochat.interfaces.Messages
import com.example.proyectochat.responses.Message

class MessagesAdapter(private val messages: ArrayList<Message>, private val view: Messages.MessagesView) : RecyclerView.Adapter<MessagesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.element_message, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val message = messages[position].message
        val username = messages[position].sentBy
        holder.username.text = username
        holder.message.text = message
    }

    override fun getItemCount(): Int {
        return messages.size
    }

    inner class ViewHolder(messageView: View): RecyclerView.ViewHolder(messageView){
        internal var username : TextView = messageView.findViewById(R.id.message_username)
        internal var message : TextView = messageView.findViewById(R.id.message_text)
    }
}