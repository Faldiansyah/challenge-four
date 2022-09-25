package com.cowok.hijrah.challenge4.fragmentscreen

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.cowok.hijrah.challenge4.R
import com.cowok.hijrah.challenge4.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    lateinit var binding: FragmentRegisterBinding
    lateinit var sharedPref: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    val shareDataRegis = "dataRegister"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPref = requireContext().getSharedPreferences(shareDataRegis, Context.MODE_PRIVATE)
        editor = sharedPref.edit()

        binding.buttonRegister.setOnClickListener {
            val username = binding.editUserRegister.text.toString()
            val email = binding.editEmailRegister.text.toString()
            val password = binding.editPassRegister.text.toString()
            val kompas = binding.editKompasRegister.text.toString()

            if (username != "" && email != "" && password != "" && kompas != ""){
                if (password == kompas){
                    editor.putString("username", username)
                    editor.putString("email", email)
                    editor.putString("password", password)
                    editor.apply()

                    Toast.makeText(context, "Register Berhasil", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
                } else {
                    Toast.makeText(context, "Konfirmasi Password Anda Salah", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(context, "Lengkapi Data Terlebih Dahulu", Toast.LENGTH_SHORT).show()
            }

        }

    }

}