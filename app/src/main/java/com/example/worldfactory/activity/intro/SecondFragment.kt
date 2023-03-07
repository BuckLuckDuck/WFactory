package com.example.worldfactory.activity.intro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.worldfactory.databinding.FragmentSecondIntroBinding

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondIntroBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondIntroBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}