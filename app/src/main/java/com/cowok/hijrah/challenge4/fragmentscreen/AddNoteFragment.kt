package com.cowok.hijrah.challenge4.fragmentscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.cowok.hijrah.challenge4.R
import com.cowok.hijrah.challenge4.databinding.FragmentAddNoteBinding
import com.cowok.hijrah.challenge4.notes.NoteData
import com.cowok.hijrah.challenge4.notes.NoteDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class AddNoteFragment : Fragment() {

    lateinit var binding: FragmentAddNoteBinding
    var dbNote: NoteDatabase? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dbNote = NoteDatabase.getInstance(requireContext())

//        binding.buttonTambahNote.setOnClickListener {
////            addNote()
//            findNavController().navigate(R.id.action_addNoteFragment_to_homeFragment)
//        }
    }

    private fun addNote() {
//        GlobalScope.async {
//            var title = binding.editTambahJudul.text.toString()
//            var note = binding.editTambahIsi.text.toString()
//
//            dbNote!!.noteDAO().insertNote(NoteData(0, title, note))
//        }
//        finish()
    }

}
