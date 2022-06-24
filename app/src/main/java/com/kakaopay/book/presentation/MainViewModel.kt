package com.kakaopay.book.presentation

import com.kakaopay.book.data.repository.BookRepository
import com.kakaopay.book.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: BookRepository
) : BaseViewModel() {
    override fun fetchData(): Job {
        return super.fetchData()
    }

}