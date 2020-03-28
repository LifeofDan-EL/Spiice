package com.danielanomfueme.freelancer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_layout)

        val button = findViewById<Button>(R.id.ButtonSignup)
        button.setOnClickListener{
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        val text = findViewById<TextView>(R.id.login)
        text.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }
}
