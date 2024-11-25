package com.example.bai6_callapi2.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bai6_callapi2.R
import com.example.bai6_callapi2.model.User


class UserAdapter(private val users: List<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val emailTextView: TextView = itemView.findViewById(R.id.emailTextView)
        val profileImageView: ImageView = itemView.findViewById(R.id.profileImageView)
        val phoneTextView: TextView = itemView.findViewById(R.id.phoneTextView)
        val cellTextView: TextView = itemView.findViewById(R.id.cellTextView)
        val genderTextView: TextView = itemView.findViewById(R.id.genderTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        holder.nameTextView.text = user.name.last
        holder.emailTextView.text = user.email
        holder.phoneTextView.text = user.phone
        holder.cellTextView.text = user.cell
        holder.genderTextView.text=user.gender
        Glide.with(holder.itemView.context).load(user.picture.large).into(holder.profileImageView)
    }

    override fun getItemCount(): Int = users.size
}