package com.kakaopay.book.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.Job

abstract class BaseFragment<VM : BaseViewModel, VB : ViewBinding> : Fragment() {

    abstract val viewModel: VM

    private var _binding: VB? = null
    val binding get() = _binding!!


    abstract fun getViewBinding(): VB


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = getViewBinding()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initState()
    }

    open fun initState() {
        initViews()
        observeData()
    }

    open fun initViews() = Unit

    abstract fun observeData()

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}