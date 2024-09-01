package com.example.whatsappclone.rvActivity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.whatsappclone.llActivity.MainActivity
import com.example.whatsappclone.databinding.ActivityRvMainBinding
import com.example.whatsappclone.rvActivity.adapters.RVAdapterChats
import com.example.whatsappclone.utils.showToast
import com.example.whatsappclone.viewModelChat.ChatViewModel
import kotlinx.coroutines.launch

class RvMainActivity : ComponentActivity() {

    private lateinit var binding: ActivityRvMainBinding
    private val chatViewModel: ChatViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRvMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
        getData()
        listenData()
    }

    private fun initViews() {
        binding.RvChats.layoutManager =
            LinearLayoutManager(this@RvMainActivity, LinearLayoutManager.VERTICAL, false)

        binding.filterAllChats.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.addChats.setOnClickListener{
            addChat()
            listenData()
            //getListSize()
            showToast("Se ha agregado un nuevo chat", Toast.LENGTH_SHORT)
            Log.d("chatadd", "añadido")
            Log.d("chatSze", "añadido ${getListSize()}")

        }

        binding.filterFavoritesChats.setOnClickListener{
            deleteChat()
            listenData()
            showToast("Se ha Eliminado un chat", Toast.LENGTH_SHORT)
            Log.d("chatDelete", "Eliminado")
            Log.d("chatSze", "Eliminado ${getListSize()}")
        }

        binding.filterGroups.setOnClickListener{
            updateChat()
            listenData()
            showToast("Se ha Modificado un chat", Toast.LENGTH_SHORT)
            Log.d("chatUpdate", "Modificado")
            Log.d("chatSze", "Modificado ${getListSize()}")
        }
    }

    private fun getListSize(): Int{
        return chatViewModel.getListSize()
    }

    private fun getData() {
        chatViewModel.getData()
    }

    private fun addChat(){
        chatViewModel.addChat()
    }

    private fun deleteChat(){
        chatViewModel.deleteChat()
    }

    private fun updateChat(){
        chatViewModel.updateChat()
    }

    private fun listenData() {
        lifecycleScope.launch {
            chatViewModel.uiState.collect { data ->
                binding.RvChats.adapter = RVAdapterChats(data.chats)
            }
        }
    }
}
