package com.cowok.hijrah.challenge4.fragmentscreen

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.cowok.hijrah.challenge4.R
import com.cowok.hijrah.challenge4.databinding.FragmentAnimationBinding

class AnimationFragment : Fragment() {

    lateinit var binding: FragmentAnimationBinding
    lateinit var sharedPref: SharedPreferences
    val shareDataLogin = "dataLogin"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAnimationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPref = requireContext().getSharedPreferences(shareDataLogin, Context.MODE_PRIVATE)
        val dataUser = sharedPref.getString("username", null)

        if (dataUser != null){
            Handler(Looper.myLooper()!!).postDelayed({
                findNavController().navigate(R.id.action_animationFragment_to_homeFragment)
            }, 3000)
        } else {
            Handler(Looper.myLooper()!!).postDelayed({
                findNavController().navigate(R.id.action_animationFragment_to_loginFragment)
            }, 3000)
        }

    }

}