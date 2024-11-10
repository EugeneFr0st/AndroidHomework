package com.example.androidhomework

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

class OnboardingActivity1 : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding1)

        sharedPreferences = getSharedPreferences("notes", MODE_PRIVATE)

        val saveButton = findViewById<Button>(R.id.saveButton)
        val noteEditText = findViewById<EditText>(R.id.noteEditText)

        saveButton.setOnClickListener {
            val noteText = noteEditText.text.toString()

            if (noteText.isNotEmpty()) {
                saveNote(noteText)
                Toast.makeText(this, "Заметка сохранена", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Введите текст заметки", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun saveNote(noteText: String) {
        val editor = sharedPreferences.edit()
        val noteCount = sharedPreferences.getInt("note_count", 0)
        editor.putString("note_$noteCount", noteText)
        editor.putInt("note_count", noteCount + 1)
        editor.apply()

    }
}