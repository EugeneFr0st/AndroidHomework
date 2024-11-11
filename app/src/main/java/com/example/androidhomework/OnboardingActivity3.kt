package com.example.androidhomework

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class OnboardingActivity3 : AppCompatActivity() {

    private lateinit var notesRecyclerView: RecyclerView
    private lateinit var adapter: NoteAdapter
    private lateinit var sharedPreferences: SharedPreferences
    private var notesList: MutableList<Note> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding3)

        notesRecyclerView = findViewById(R.id.notesRecycler_view)
        sharedPreferences = getSharedPreferences("notes", MODE_PRIVATE)

        loadNotes()
        setupRecyclerView()
    }

    private fun loadNotes() {
        notesList.clear()
        val noteCount = sharedPreferences.getInt("note_count", 0)

        for (i in 0 until noteCount) {
            val title = sharedPreferences.getString("note_${i}_title", null)
            val date = sharedPreferences.getString("note_${i}_date", null)
            val noteText = sharedPreferences.getString("note_${i}_text", null)

            if (title != null && date != null && noteText != null) {
                notesList.add(Note(i, title, noteText, date))
            }
        }
    }

    private fun setupRecyclerView() {
        adapter = NoteAdapter(notesList, { position ->
            adapter.removeAt(position)
        }, sharedPreferences)
        notesRecyclerView.layoutManager = LinearLayoutManager(this)
        notesRecyclerView.adapter = adapter
    }
}