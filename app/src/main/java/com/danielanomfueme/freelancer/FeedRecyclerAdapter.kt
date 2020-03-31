package com.danielanomfueme.freelancer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.feed_project_layout.view.*
import models.FeedProject

class FeedRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private  var items: List<FeedProject> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return FeedProjectViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.feed_project_layout, parent, false)
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

    fun submitList(feedProjectList: List<FeedProject>){
        items = feedProjectList
    }

    class FeedProjectViewHolder constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView){
        val interactionTitle = itemView.int_title
        val interactionName = itemView.int_name
        val interactionStatus = itemView.int_status

        fun bind (feedProject : FeedProject){
            interactionTitle.setText(feedProject.title)
            interactionName.setText(feedProject.name)
            interactionStatus.setText(feedProject.status)
        }
    }
}