package com.example.variant11app.presentation.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.variant11app.databinding.FragmentAboutBinding
import com.example.variant11app.presentation.util.collectOnLifecycle
import org.koin.androidx.viewmodel.ext.android.viewModel

class AboutFragment : Fragment() {
    private lateinit var binding: FragmentAboutBinding
    private val viewModel: AboutViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAboutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObservers()
    }

    private fun setUpObservers() {
        collectOnLifecycle(viewModel.name) { binding.textName.text = it }
        collectOnLifecycle(viewModel.groupName) { binding.textGroupName.text = it }
        collectOnLifecycle(viewModel.message) { binding.textMessage.text = it }
    }
}