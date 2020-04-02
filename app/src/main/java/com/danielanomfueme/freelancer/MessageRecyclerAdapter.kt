package com.danielanomfueme.freelancer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.feed_project_layout.view.*
import kotlinx.android.synthetic.main.feed_project_layout.view.int_status
import kotlinx.android.synthetic.main.message_layout_list.view.*
import models.MessageProject

class MessageRecyclerAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private  var items: List<MessageProject> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return FeedProjectViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.message_layout_list, parent, false)
        )
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is FeedProjectViewHolder ->{
                holder.bind(items.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(messageProjectList: List<MessageProject>){
        items = messageProjectList
    }

    class FeedProjectViewHolder constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView){
        val interacttionImage = itemView.icon_image
        val interactionUsername = itemView.name_text
        val interactionMessage = itemView.message_text

        fun bind (messageProject : MessageProject){
            interactionUsername.setText(messageProject.username)
            interactionMessage.setText(messageProject.message)

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(messageProject.image)
                .into(interacttionImage)
        }

}}
