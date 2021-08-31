package com.book.exomind_test.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.book.exomind_test.databinding.MainFragmentBinding
import com.book.exomind_test.ui.progress.ProgressActivity

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var binding: MainFragmentBinding
    private  var viewModel= MainViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.mainViewModel = viewModel

        handleClick()

        return binding.root
    }

    private fun handleClick() {
        binding.mainViewModel?.clickstate?.observe(viewLifecycleOwner, Observer {
            if (it) {
                val intent = Intent(activity,ProgressActivity::class.java)
                startActivity(intent)
            }
        })
    }


}