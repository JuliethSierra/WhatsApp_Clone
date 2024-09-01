package com.example.whatsappclone.rvActivity.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappclone.data.Chat
import com.example.whatsappclone.databinding.ChatsScreenBinding

class RVAdapterChats(private val chats: List<Chat>) :
    RecyclerView.Adapter<RVAdapterChats.ChatsViewHolder>() {

    class ChatsViewHolder(val binding: ChatsScreenBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatsViewHolder {
        val chatView = ChatsScreenBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChatsViewHolder(chatView)
    }

    override fun onBindViewHolder(holder: ChatsViewHolder, position: Int) {
        holder.binding.imageProfilePicture.setImageResource(chats[position].profilePhoto)
        holder.binding.chatName.text = chats[position].chatName
        holder.binding.message.text = chats[position].message
        holder.binding.date.text = chats[position].messageDate
        holder.binding.numberChats.text = chats[position].messageCount
    }

    override fun getItemCount(): Int = chats.size
}
