package com.example.myapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.myapp.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toSecond = FirstFragmentDirections.actionFirstFragmentToSecondFragment()
        toSecond.name = "Ridho"
        toSecond.number = 9
        binding.btn1.setOnClickListener {
            it.findNavController().navigate(toSecond)
        }
        binding.btn2.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_myVMFragment)
        }
        binding.btn3.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_myLDFragment)
        }
        binding.btn4.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_saveApiFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}