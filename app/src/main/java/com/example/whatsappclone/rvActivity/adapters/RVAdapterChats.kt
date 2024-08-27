package com.example.whatsappclone.rvActivity.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappclone.Chat
import com.example.whatsappclone.R
import de.hdodenhof.circleimageview.CircleImageView

class RVAdapterChats (private val chats: List<Chat>):
    RecyclerView.Adapter<RVAdapterChats.ChatsViewHolder>(){

    class ChatsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val profilePhoto : CircleImageView = view.findViewById(R.id.imageProfilePicture)
        val chatName: TextView = view.findViewById(R.id.chatName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatsViewHolder {
        val chatView = LayoutInflater.from(parent.context)
            .inflate(R.layout.main_chat_screen, parent, false)
        return ChatsViewHolder(chatView)
    }

    override fun getItemCount(): Int = chats.size

    override fun onBindViewHolder(holder: ChatsViewHolder, position: Int) {
        holder.profilePhoto.setImageResource(chats[position].profilePhoto)
        holder.chatName.text = chats[position].chatName
    }

}
