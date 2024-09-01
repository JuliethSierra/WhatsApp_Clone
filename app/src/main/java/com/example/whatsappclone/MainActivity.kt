package com.example.whatsappclone

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.instagramclone.showToast
import de.hdodenhof.circleimageview.CircleImageView

class MainActivity : ComponentActivity() {

    private lateinit var llChats: LinearLayout
    private val chatList = arrayListOf<Chat>()


    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_WhatsAppClone)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_chat_screen)
        initViews()
        fillPostList()
        addPostsToLL()
    }

    /*  private fun fillPostList() {
          for (i in 0 until 10) {
              chatList.add(Chat("photo1.jpg", "Chat 1", "Hola, ¿cómo estás?", "2024-08-25", "3"))
          }
      }*/

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

    private fun addPostsToLL() {
        chatList.forEach { chat ->

            val postView = layoutInflater.inflate(R.layout.chats_screen, null)

            val profilePhoto: CircleImageView = postView.findViewById(R.id.imageProfilePicture)
            profilePhoto.setImageResource(chat.profilePhoto)

            val chatName: TextView = postView.findViewById(R.id.chatName)
            chatName.text = chat.chatName
            chatName.setOnClickListener {
                showToast("${chat.chatName}")
            }

            val message: TextView = postView.findViewById(R.id.message)
            message.text = chat.message
            message.setOnClickListener {
                showToast("${chat.message}")
            }

            val messageDate: TextView = postView.findViewById(R.id.date)
            messageDate.text = chat.messageDate
            messageDate.setOnClickListener {
                showToast("${chat.messageDate}")
            }

            val messageCount: TextView = postView.findViewById(R.id.numberChats)
            messageCount.text = chat.messageCount
            messageCount.setOnClickListener {
                showToast("${chat.messageCount}")
            }

            llChats.addView(postView)
        }
    }

    private fun initViews() {
        llChats = findViewById(R.id.ll_chats)
    }
}