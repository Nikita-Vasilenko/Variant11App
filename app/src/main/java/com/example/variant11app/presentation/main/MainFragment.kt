package com.example.variant11app.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.variant11app.R
import com.example.variant11app.databinding.FragmentMainBinding
import com.example.variant11app.presentation.util.collectOnLifecycle
import com.example.variant11app.presentation.util.NavigationEvent
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val viewModel: MainViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpOnClickListeners()
        setUpNavigation()
    }

    private fun setUpOnClickListeners() {
        binding.buttonReverse.setOnClickListener { viewModel.onReverseClicked() }
        binding.buttonAbout.setOnClickListener { viewModel.onAboutClicked() }
        binding.buttonExit.setOnClickListener { viewModel.onExitClicked() }
    }

    private fun setUpNavigation() {
        collectOnLifecycle(viewModel.events) { event ->
            when (event) {
                NavigationEvent.Reverse -> navigateToReverseFragment()
                NavigationEvent.About -> navigateToAboutFragment()
                NavigationEvent.Back -> requireActivity().onBackPressed()
            }
        }
    }

    private fun navigateToReverseFragment() {
        if (findNavController().currentDestination?.id == R.id.mainFragment) {
            findNavController().navigate(R.id.action_mainFragment_to_reverseDialogFragment)
        }
    }

    private fun navigateToAboutFragment() {
        if (findNavController().currentDestination?.id == R.id.mainFragment) {
            findNavController().navigate(R.id.action_mainFragment_to_aboutFragment)
        }
    }
}