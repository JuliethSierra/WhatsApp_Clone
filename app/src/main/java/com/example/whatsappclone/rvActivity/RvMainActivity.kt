package com.example.whatsappclone.rvActivity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappclone.Chat
import com.example.whatsappclone.R
import com.example.whatsappclone.rvActivity.adapters.RVAdapterChats

class RvMainActivity : AppCompatActivity() {

    private lateinit var rvChats: RecyclerView
    private val chatList = arrayListOf<Chat>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rv_main)
        fillPostList()
        initViews()
        }

    private fun initViews() {
        rvChats = findViewById(R.id.RvChats)
        rvChats.apply {
            layoutManager = LinearLayoutManager(this@RvMainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = RVAdapterChats(chatList)
        }
    }

    private fun fillPostList() {
        chatList.add(
            Chat(
                R.drawable.media_photo,
                "Chat 1",
                "Hola, ¿cómo estás?",
                "7/24/24",
                "1"
            )
        )
        chatList.add(Chat(R.drawable.media_photo, "Chat 2", "Nos vemos mañana", "8/22/24", "1"))
        chatList.add(
            Chat(
                R.drawable.media_photo,
                "Chat 3",
                "¡Feliz cumpleaños!",
                "8/22/24",
                "10"
            )
        )
        chatList.add(
            Chat(
                R.drawable.media_photo,
                "Chat 4",
                "¿Qué tal el proyecto?",
                "5/24/24",
                "5"
            )
        )
        chatList.add(
            Chat(
                R.drawable.media_photo,
                "Chat 5",
                "¿Vas a la reunión?",
                "5/12/24",
                "2"
            )
        )
        chatList.add(
            Chat(
                R.drawable.media_photo,
                "Chat 6",
                "Te envío los documentos",
                "5/11/24",
                "7"
            )
        )
        chatList.add(
            Chat(
                R.drawable.media_photo,
                "Chat 7",
                "Nos hablamos luego",
                "5/11/24",
                "5"
            )
        )
        chatList.add(Chat(R.drawable.media_photo, "Chat 8", "Necesito tu ayuda", "5/11/24", "6"))
        chatList.add(
            Chat(
                R.drawable.media_photo,
                "Chat 9",
                "¡Gracias por todo!",
                "5/11/24",
                "9"
            )
        )
        chatList.add(Chat(R.drawable.media_photo, "Chat 10", "Hola!", "5/10/24", "1"))
        chatList.add(Chat(R.drawable.media_photo, "Chat 11", "Estás ocupada", "5/10/24", "1"))
        chatList.add(Chat(R.drawable.media_photo, "Chat 12", "Estoy en camino", "5/10/24", "2"))
        chatList.add(Chat(R.drawable.media_photo, "Chat 13", "¿Como estás?", "5/10/24", "1"))
        chatList.add(Chat(R.drawable.media_photo, "Chat 14", "Hola", "5/9/24", "1"))
        chatList.add(Chat(R.drawable.media_photo, "Chat 15", "Estoy en camino", "5/9/24", "2"))
    }


    }
