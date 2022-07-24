package com.kakaopay.book.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.kakaopay.book.data.model.BookItemResponse
import com.kakaopay.book.data.api.BookSearchApi
import com.kakaopay.book.util.Constants.PAGING_SIZE
import retrofit2.HttpException
import java.io.IOException

class BookSearchPagingSource(
    private val api: BookSearchApi,
    private val query: String
) : PagingSource<Int, BookItemResponse>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, BookItemResponse> {
        return try {
            val pageNumber = params.key ?: STARTING_PAGE_INDEX

            val response = api.getBooks(query, pageNumber, 50)
            val endOfPaginationReached = response.body()?.meta?.isEnd ?:false

            val data = response.body()?.documents ?: listOf()
            val prevKey = if (pageNumber == STARTING_PAGE_INDEX) null else pageNumber - 1
            val nextKey = if (endOfPaginationReached) { // 끝인지 확인
                null
            } else {
                pageNumber + (params.loadSize / PAGING_SIZE)
            }
            LoadResult.Page(
                data = data,
                prevKey = prevKey,
                nextKey = nextKey,
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, BookItemResponse>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    companion object {
        const val STARTING_PAGE_INDEX = 1
    }
}