package com.example.myapp

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapp.databinding.FragmentFirstBinding
import com.example.myapp.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dataName = SecondFragmentArgs.fromBundle(arguments as Bundle).name
        val dataNumber = SecondFragmentArgs.fromBundle(arguments as Bundle).number
        binding.btn2.text = "$dataName $dataNumber"
        binding.btn2.setOnClickListener {
            findNavController().navigate(SecondFragmentDirections.actionSecondFragmentToFirstFragment())
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}