package com.kakaopay.book.data.repository

import androidx.paging.PagingData
import com.kakaopay.book.data.model.BookItemResponse
import kotlinx.coroutines.flow.Flow

interface BookRepository {
    

    fun searchBooksPaging(query: String): Flow<PagingData<BookItemResponse>>
}