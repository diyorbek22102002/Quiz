package com.example.presentetion.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quizapp.R
import com.example.quizapp.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {
     lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingsBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    val deleteHistory = binding.ClearHistory
    val shareThisApp = binding.shareThisApp
    val leaveFeedBeck = binding.leaveFeedBeck
    val reteUs = binding.reteUs


}