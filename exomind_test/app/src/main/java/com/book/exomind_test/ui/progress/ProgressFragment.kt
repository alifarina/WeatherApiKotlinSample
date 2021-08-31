package com.book.exomind_test.ui.progress

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.book.exomind_test.data.remote.WeatherRepository
import com.book.exomind_test.databinding.MainFragmentBinding
import com.book.exomind_test.databinding.ProgreessFragmentBinding

class ProgressFragment : Fragment() {

    companion object {
        fun newInstance() = ProgressFragment()
    }

    private lateinit var binding: ProgreessFragmentBinding
    val repository = WeatherRepository()
    private var viewModel = ProgressViewModel(repository)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ProgreessFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.progressModel = viewModel

        return binding.root
    }


}