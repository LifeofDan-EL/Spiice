package com.danielanomfueme.freelancer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.NonNull
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_feed.*

class FeedActivity : AppCompatActivity() {


    private lateinit var feedAdapter: FeedRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feed_layout)
        initRecyclerView()
        addDataSet()


        val bottomNavigationView : BottomNavigationView = findViewById(R.id.bottom_nav)

//        bottomNavigationView.setOnNavigationItemSelectedListener()
//        run({ R.id.feed })
//        bottomNavigationView.setOnNavigationItemSelectedListener(object:BottomNavigationView.OnNavigationItemSelectedListener() {
//            override fun onNavigationItemSelected(@NonNull menuitem: MenuItem):Boolean {
//                val menuItem
//                when (menuItem.getItemId()) {
//                    R.id.Message -> {
//                        val intent = Intent (this, MessagesActivity::class.java)
//                        startActivity(intent)
//                        overridePendingTransition(0, 0)
//
//                        return true
//                    }
//                    R.id.feed -> return true
//                    R.id.dashboard -> {
//                        startActivity(Intent(getApplicationContext(, Dashboard::class.java)))
//                        overridePendingTransition(0, 0)
//                        return true
//                    }
//                }
//                return false
//            }
//        })
    }

    private fun addDataSet(){
        val data = DataSource.createDataSet()
        feedAdapter.submitList(data)
    }

    private fun initRecyclerView(){
        feed_recycler_view.apply {
            layoutManager = LinearLayoutManager(this@FeedActivity)
            feedAdapter = FeedRecyclerAdapter()
            adapter = feedAdapter
        }

    }

}
