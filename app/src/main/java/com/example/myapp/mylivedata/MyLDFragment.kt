package com.example.myapp.mylivedata

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.myapp.R
import com.example.myapp.databinding.FragmentMyLDBinding
import com.example.myapp.databinding.FragmentMyVMBinding

class MyLDFragment : Fragment() {

    private var _binding: FragmentMyLDBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MyLDViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMyLDBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribe()
    }

    private fun subscribe() {
        val elapsedTimeObserver = Observer<Long?> { aLong ->
            val newText = requireContext().resources.getString(R.string.seconds, aLong)
            binding.timerTextview.text = newText
        }
        viewModel.getElapsedTime().observe(viewLifecycleOwner, elapsedTimeObserver)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}