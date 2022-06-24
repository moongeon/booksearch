package com.kakaopay.book.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.kakaopay.book.data.model.BookItemResponse
import com.kakaopay.book.data.model.BookResponse
import com.kakaopay.book.data.api.BookSearchApi
import com.kakaopay.book.util.Constants.PAGING_SIZE
import retrofit2.Response
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(
    private val bookSearchApi: BookSearchApi
) : BookRepository {

    override suspend fun getBookList(
        query: String,
        page: Int,
        size: Int
    ) : Response<BookResponse>
    {
        return bookSearchApi.getBooks(query, page, size)
    }

    override fun searchBooksPaging(query: String) : Flow<PagingData<BookItemResponse>> {
        val pagingSourceFactory = { BookSearchPagingSource(bookSearchApi, query) }

        return Pager(
            config = PagingConfig(
                pageSize = PAGING_SIZE,
                enablePlaceholders = false,
                maxSize = PAGING_SIZE * 3
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }



}