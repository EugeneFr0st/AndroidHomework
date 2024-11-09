package com.example.androidhomework

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OnboardingActivity3 : AppCompatActivity() {

    private lateinit var notesTextView: TextView
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding3)

        notesTextView = findViewById(R.id.notesTextView)
        sharedPreferences = getSharedPreferences("notes", MODE_PRIVATE)

        displayNotes()
    }

    private fun displayNotes() {
        val noteCount = sharedPreferences.getInt("note_count", 0)
        val notes = StringBuilder()

        for (i in 0 until noteCount) {
            val note = sharedPreferences.getString("note_$i", null)
            if (note != null) {
                notes.append(note).append("\n")
            }
        }

        notesTextView.text = if (notes.isNotEmpty()) notes.toString() else "Нет сохраненных заметок"
    }
}