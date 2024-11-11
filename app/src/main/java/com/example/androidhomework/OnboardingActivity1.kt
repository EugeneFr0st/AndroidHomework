package com.example.androidhomework

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class OnboardingActivity1 : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding1)

        sharedPreferences = getSharedPreferences("notes", MODE_PRIVATE)

        val saveButton = findViewById<Button>(R.id.saveButton)
        val noteEditText = findViewById<EditText>(R.id.noteEditText)
        val titleEditText = findViewById<EditText>(R.id.titleEditText)

        saveButton.setOnClickListener {
            val title = titleEditText.text.toString()
            val noteText = noteEditText.text.toString()

            if (title.isNotEmpty() && noteText.isNotEmpty()) {
                saveNote(title, noteText)
                Toast.makeText(this, getString(R.string.save_message_success), Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, getString(R.string.save_message_failed), Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun saveNote(title: String, noteText: String) {
        val editor = sharedPreferences.edit()
        val noteCount = sharedPreferences.getInt("note_count", 0)
        val currentDate = SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.getDefault()).format(Date())

        editor.putString("note_${noteCount}_title", title)
        editor.putString("note_${noteCount}_date", currentDate)
        editor.putString("note_${noteCount}_text", noteText)
        editor.putInt("note_count", noteCount + 1)
        editor.apply()
    }
}
