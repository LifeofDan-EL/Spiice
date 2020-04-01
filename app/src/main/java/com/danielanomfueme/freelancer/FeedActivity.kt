package com.danielanomfueme.freelancer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.NonNull
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class FeedActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feed_layout)

        val bottomNavigationView : BottomNavigationView = findViewById(R.id.bottom_nav)

        bottomNavigationView.setOnNavigationItemSelectedListener()
        run({ R.id.feed })
        bottomNavigationView.setOnNavigationItemSelectedListener(object:BottomNavigationView.OnNavigationItemSelectedListener() {
            override fun onNavigationItemSelected(@NonNull menuitem: MenuItem):Boolean {
                val menuItem
                when (menuItem.getItemId()) {
                    R.id.Message -> {
                        val intent = Intent (this, MessagesActivity::class.java)
                        startActivity(intent)
                        overridePendingTransition(0, 0)

                        return true
                    }
                    R.id.feed -> return true
                    R.id.dashboard -> {
                        startActivity(Intent(getApplicationContext(, Dashboard::class.java)))
                        overridePendingTransition(0, 0)
                        return true
                    }
                }
                return false
            }
        })
    }
}
