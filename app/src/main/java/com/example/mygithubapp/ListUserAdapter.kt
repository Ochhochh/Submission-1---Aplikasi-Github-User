package com.example.mygithubapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class ListUserAdapter (private val listUser: ArrayList<User>) : RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    class ListViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgAvatar : ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvUsername : TextView = itemView.findViewById(R.id.tv_username)
        var tvName : TextView = itemView.findViewById(R.id.tv_name)
        var tvRepository : TextView = itemView.findViewById(R.id.tv_repository)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_user, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (avatar, username, name, repository) = listUser[position]
        holder.imgAvatar.setImageResource(avatar)
        holder.tvUsername.text = username
        holder.tvName.text = name
        holder.tvRepository.text = "   |   $repository Repository"
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listUser[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listUser.size

    interface OnItemClickCallback {
        fun onItemClicked(data: User)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
}