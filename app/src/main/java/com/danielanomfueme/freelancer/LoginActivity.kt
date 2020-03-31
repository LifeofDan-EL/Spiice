package com.danielanomfueme.freelancer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val button = findViewById<Button>(R.id.ButtonSignup)
        button.setOnClickListener{
            val intent = Intent(this, FeedActivity::class.java)
            startActivity(intent)
        }
    }
}
