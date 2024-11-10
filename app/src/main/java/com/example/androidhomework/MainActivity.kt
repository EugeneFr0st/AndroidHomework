package com.example.androidhomework

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val welcomeTextView = findViewById<TextView>(R.id.welcomeTextView)

        val username = intent.getStringExtra("username")
        val welcomeMessage = getString(R.string.welcome_message, username)
        welcomeTextView.text = welcomeMessage

        val viewNotesButton = findViewById<Button>(R.id.viewNotesButton)
        val addNoteButton = findViewById<Button>(R.id.addNoteButton)

        viewNotesButton.setOnClickListener {
            val intent = Intent(this, OnboardingActivity1::class.java)
            startActivity(intent)
        }

        addNoteButton.setOnClickListener {
            val intent = Intent(this, OnboardingActivity3::class.java)
            startActivity(intent)

        }
    }
}