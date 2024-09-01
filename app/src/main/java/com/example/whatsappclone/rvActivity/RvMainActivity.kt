package com.example.whatsappclone.rvActivity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.whatsappclone.data.Chat
import com.example.whatsappclone.llActivity.MainActivity
import com.example.whatsappclone.R
import com.example.whatsappclone.databinding.ActivityRvMainBinding
import com.example.whatsappclone.rvActivity.adapters.RVAdapterChats

class RvMainActivity : ComponentActivity() {

    private lateinit var binding: ActivityRvMainBinding
    private val chatList = arrayListOf<Chat>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRvMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fillPostList()
        initViews()
    }

    private fun initViews() {
        binding.RvChats.apply {
            layoutManager = LinearLayoutManager(this@RvMainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = RVAdapterChats(chatList)
        }
        binding.filterAllChats.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
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
