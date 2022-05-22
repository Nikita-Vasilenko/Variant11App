package com.example.variant11app.presentation.reverse

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.DialogFragment
import com.example.variant11app.databinding.FragmentReverseDialogBinding
import com.example.variant11app.presentation.util.collectOnLifecycle
import org.koin.androidx.viewmodel.ext.android.viewModel

class ReverseDialogFragment : DialogFragment() {

    private lateinit var binding: FragmentReverseDialogBinding
    private val viewModel: ReverseViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentReverseDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpCaseCheckBox()
        setUpOrderCheckbox()
        setUpInput()
        setUpOkButton()
    }

    private fun setUpCaseCheckBox() = binding.checkboxCase.apply {
        setOnCheckedChangeListener { _, isChecked -> viewModel.onUpperCaseChecked(isChecked) }
        collectOnLifecycle(viewModel.isCaseCheckboxEnabled) {
            isEnabled = it
            if (!it) isChecked = false
        }
    }

    private fun setUpOrderCheckbox() = binding.checkboxOrder.apply {
        setOnCheckedChangeListener { _, _ -> viewModel.onReverseChecked() }
        collectOnLifecycle(viewModel.isOrderCheckboxEnabled) {
            isEnabled = it
            if (!it) isChecked = false
        }
    }

    private fun setUpInput() = binding.editInput.apply {
        this.doAfterTextChanged { viewModel.onInputChanged(it.toString()) }
        collectOnLifecycle(viewModel.message) {
            setText(it)
            setSelection(it.length)
        }
    }

    private fun setUpOkButton() = binding.buttonOk.setOnClickListener { dismiss() }
}