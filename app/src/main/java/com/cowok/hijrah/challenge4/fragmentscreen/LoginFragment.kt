package com.cowok.hijrah.challenge4.fragmentscreen

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.cowok.hijrah.challenge4.R
import com.cowok.hijrah.challenge4.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding
    lateinit var sharedPrefRegis: SharedPreferences
    lateinit var sharedPrefLogin: SharedPreferences
    lateinit var editorLogin: SharedPreferences.Editor
    val shareDataRegis = "dataRegister"
    val shareDataLogin = "dataLogin"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPrefLogin = requireContext().getSharedPreferences(shareDataLogin, 0)
        sharedPrefRegis = requireContext().getSharedPreferences(shareDataRegis, 0)
        editorLogin = sharedPrefLogin.edit()

        binding.buttonLogin.setOnClickListener {
            val email = binding.editEmailLogin.text.toString()
            val password = binding.editPassLogin.text.toString()
            val emailRegis = sharedPrefRegis.getString("email", "")
            val passRegis = sharedPrefRegis.getString("password", "")

            if (email == emailRegis && password == passRegis){
                if (emailRegis == "" && passRegis == ""){
                    Toast.makeText(context, "Data Tidak Ada, Registrasi Terlebih Dahulu",
                        Toast.LENGTH_SHORT).show()
                } else {
                    editorLogin.putString("username", email)
                    editorLogin.putString("password", password)
                    editorLogin.apply()

                    Toast.makeText(context, "Login Berhasil", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                }
            } else {
                Toast.makeText(context, "Username atau Password Anda Salah", Toast.LENGTH_SHORT).show()
            }
        }

        binding.textRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

    }

}