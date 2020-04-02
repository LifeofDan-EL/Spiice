package com.danielanomfueme.freelancer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_messages.*

class MessagesActivity : AppCompatActivity() {
    private lateinit var messageAdapter: MessageRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messages)

       initRecyclerView()
        addDataSet()
    }

    private fun addDataSet(){
        val data = MessageDataSource.createDataSet()
        messageAdapter.submitList(data)
    }

    private fun initRecyclerView(){
        message_recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MessagesActivity)
            messageAdapter = MessageRecyclerAdapter()
            adapter = messageAdapter
        }

    }
}
