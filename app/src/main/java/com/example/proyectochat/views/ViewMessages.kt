package com.example.proyectochat.views


import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectochat.MessagesAdapter

import com.example.proyectochat.R
import com.example.proyectochat.UsersAdapter
import com.example.proyectochat.interfaces.FragmentLauncher
import com.example.proyectochat.interfaces.Messages
import com.example.proyectochat.presenters.PresenterMessages
import com.example.proyectochat.responses.Message
import com.example.proyectochat.responses.User
import kotlinx.android.synthetic.main.fragment_view_messages.*
import java.util.*
import kotlin.collections.ArrayList




// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ViewMessages(private val launcher: FragmentLauncher, private val token: String, private val toID: String) : Fragment(), Messages.MessagesView {

    private lateinit var presenter : PresenterMessages

    val mainHandler = Handler(Looper.getMainLooper())


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_view_messages, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = PresenterMessages(this)
        presenter.getMessages(token, toID)

        messages_button_enviar.setOnClickListener {
            val message = message_text_edit.text.toString()
            presenter.postMessage(token, toID, message)
        }

        messages_button_salir.setOnClickListener {
            presenter.loadDashboardView(token)
        }

        mainHandler.post(object : Runnable {
            override fun run() {
                presenter.getMessages(token, toID)
                mainHandler.postDelayed(this, 5000)
            }
        })


    }

    override fun inflateListOfMessages(messages: ArrayList<Message>) {
        val manager = LinearLayoutManager(context)
//        manager.stackFromEnd = true
        manager.reverseLayout = true
        messages_recycler.layoutManager = manager
        messages_recycler.adapter = MessagesAdapter(messages, this)
        messages_recycler.scrollToPosition(0)
    }

    override fun loadDashboardView(token: String) {
        mainHandler.removeCallbacksAndMessages(null);
        launcher.launchDashboard(token)
    }

    override fun showMessagePosted(message: String) {
        presenter.getMessages(token, toID)
    }

    override fun showError(error: String) {
        Toast.makeText(this.context, error, Toast.LENGTH_LONG).show()
    }

    override fun cleanTextinput() {
        message_text_edit.text.clear()
    }

}
