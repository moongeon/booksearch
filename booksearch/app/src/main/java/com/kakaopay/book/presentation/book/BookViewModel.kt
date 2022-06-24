package com.kakaopay.book.presentation.book

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.kakaopay.book.data.model.BookItemResponse
import com.kakaopay.book.data.repository.BookRepository
import com.kakaopay.book.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookViewModel @Inject constructor(
    private val bookRepository: BookRepository
) : BaseViewModel() {

    private val _searchPagingResult =
        MutableStateFlow<PagingData<BookItemResponse>>(PagingData.empty())
    val searchPagingResult: StateFlow<PagingData<BookItemResponse>>
        get() = _searchPagingResult


    fun search(query: String) {
        viewModelScope.launch {
            bookRepository.searchBooksPaging(query).cachedIn(viewModelScope)
                .collect { _searchPagingResult.value = it }
        }


    }


}