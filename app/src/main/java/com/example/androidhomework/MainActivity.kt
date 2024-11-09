package com.example.androidhomework

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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