package com.kakaopay.book.data.repository

import androidx.paging.PagingData
import com.kakaopay.book.data.model.BookItemResponse
import com.kakaopay.book.data.model.BookResponse
import retrofit2.Response
import kotlinx.coroutines.flow.Flow
interface BookRepository {

    suspend fun getBookList(
        query: String,
        page: Int = 1,
        size: Int = 50
    ): Response<BookResponse>


    fun searchBooksPaging(query: String) : Flow<PagingData<BookItemResponse>>
}