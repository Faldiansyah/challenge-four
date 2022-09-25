package com.cowok.hijrah.challenge4.fragmentscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.cowok.hijrah.challenge4.R
import com.cowok.hijrah.challenge4.databinding.FragmentEditNoteBinding
import com.cowok.hijrah.challenge4.databinding.FragmentHomeBinding

class EditNoteFragment : Fragment() {

    lateinit var binding: FragmentEditNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEditNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonUbahNote.setOnClickListener {
//            findNavController().navigate(R.id)
        }
    }

}