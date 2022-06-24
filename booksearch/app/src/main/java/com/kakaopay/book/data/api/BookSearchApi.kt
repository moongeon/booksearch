package com.kakaopay.book.data.api

import com.kakaopay.book.data.model.BookResponse
import com.kakaopay.book.util.Constants.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface BookSearchApi {

    @Headers("Authorization: KakaoAK $API_KEY")
    @GET("/v3/search/book")
    suspend fun getBooks(
        @Query(value = "query") userQuery: String,
        @Query(value = "page") page: Int,
        @Query(value = "size") size: Int
    ): Response<BookResponse>

}