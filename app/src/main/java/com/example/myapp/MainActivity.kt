package com.example.myapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val welcometext: TextView =findViewById(R.id.welcometext)
//        val loginbutton: TextView = findViewById(R.id.loginbutton)
//        loginbutton.setOnClickListener{
//            welcometext.text="Logged In"
//        }
    }

}