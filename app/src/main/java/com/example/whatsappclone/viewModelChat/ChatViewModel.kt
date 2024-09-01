package com.example.whatsappclone.viewModelChat

import androidx.lifecycle.ViewModel
import com.example.whatsappclone.R
import com.example.whatsappclone.data.Chat
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.random.Random

class ChatViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ChatIUState())
    val uiState: StateFlow<ChatIUState> = _uiState.asStateFlow()

    private val chatList = arrayListOf<Chat>()

    private var chatCount = 0

    init {
        fillPostList()
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

    fun getData() {
        _uiState.value = _uiState.value.copy(
            chats = chatList
        )
    }

    fun addChat() {
        chatCount++
        chatList.add(
            Chat(
                R.drawable.media_photo,
                "Chat $chatCount",
                "Nuevo Mensaje $chatCount",
                "5/9/24",
                "2"
            )
        )
        _uiState.value = _uiState.value.copy(
            chats = chatList
        )
    }

    fun getListSize(): Int {
        return chatList.size
    }

    fun deleteChat() {
        val chatToRemoveIndex = Random.nextInt(from = 0, until = getListSize())
        chatList.removeAt(chatToRemoveIndex)
        _uiState.value = _uiState.value.copy(
            chats = chatList
        )
    }

    fun updateChat() {
        val chatToUpdateIndex = Random.nextInt(from = 0, until = getListSize())
        val chat =
            // Access post using index
            chatList[chatToUpdateIndex]
                // Using copy, we access and modify the existing post (accessed by index)
                .copy(
                    chatName = "ChatName #$chatToUpdateIndex modificado"
                )
        // Replace the old post with the new one using index
        chatList[chatToUpdateIndex] = chat

        _uiState.value = _uiState.value.copy(
            chats = chatList
        )
    }

}