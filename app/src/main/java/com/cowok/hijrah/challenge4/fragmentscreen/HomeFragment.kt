package com.cowok.hijrah.challenge4.fragmentscreen

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.ActivityNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.cowok.hijrah.challenge4.R
import com.cowok.hijrah.challenge4.databinding.FragmentHomeBinding
//import com.cowok.hijrah.challenge4.notes.NoteAdapter
import com.cowok.hijrah.challenge4.notes.NoteDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    lateinit var sharedPrefRegis: SharedPreferences
    lateinit var sharedPrefLogin: SharedPreferences
    lateinit var editorLogin: SharedPreferences.Editor
    val shareDataRegis = "dataRegister"
    val shareDataLogin = "dataLogin"
    var NoteDB: NoteDatabase? = null
//    lateinit var adapterNote: NoteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPrefRegis = requireContext().getSharedPreferences(shareDataRegis,
            Context.MODE_PRIVATE
        )
        sharedPrefLogin = requireContext().getSharedPreferences(shareDataLogin,
            Context.MODE_PRIVATE
        )
        editorLogin = sharedPrefLogin.edit()

        val username = sharedPrefRegis.getString("username", "")
        binding.textWelcome.text = "Selamat Datang\n$username"

        binding.buttonLogout.setOnClickListener {
            editorLogin.clear()
            editorLogin.apply()

            Toast.makeText(context, "Anda Berhasil Logout", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_homeFragment_to_loginFragment)
        }


        NoteDB = NoteDatabase.getInstance(requireContext())

        binding.buttonAdd.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addNoteFragment)
        }



//        getAllNote()
    }

    private fun getAllNote() {
        GlobalScope.launch {
            var data = NoteDB?.noteDAO()?.getDataNote()
//            this@HomeFragment.getActivity().RunOnUiThread {
//                adapterNote = NoteAdapter(data!!)
//                binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
//                binding.recyclerView.adapter = adapterNote
//            }

        }
    }

}
