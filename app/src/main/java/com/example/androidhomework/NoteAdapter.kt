package com.example.androidhomework

import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter(
    private val notes: MutableList<Note>,
    private val onDeleteClick: (Int) -> Unit,
    private val sharedPreferences: SharedPreferences
) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    class NoteViewHolder(noteView: View) : RecyclerView.ViewHolder(noteView) {
        val textView: TextView = noteView.findViewById(R.id.text_view)
        val titleView: TextView = noteView.findViewById(R.id.title_view)
        val dateView: TextView = noteView.findViewById(R.id.date_view)
        val deleteButton: Button = noteView.findViewById(R.id.delete_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_layout, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position] as Note
        holder.titleView.text = note.title
        holder.textView.text = note.note
        holder.dateView.text = note.date
        holder.deleteButton.setOnClickListener {
            onDeleteClick(position)
        }
    }

    override fun getItemCount() = notes.size

    fun removeAt(position: Int) {
        notes.removeAt(position)
        notifyItemRemoved(position)

        saveNotesToPreferences()
    }

    private fun saveNotesToPreferences() {
        val editor = sharedPreferences.edit()
        editor.putInt("note_count", notes.size)
        for (i in notes.indices) {
            editor.putString("note_$i", notes[i].note)
        }
        editor.apply()
    }
}