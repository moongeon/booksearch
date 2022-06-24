package com.kakaopay.book.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class BookResponse(
    @SerializedName("meta") val meta: BookMetaResponse,
    @SerializedName("documents") val documents: List<BookItemResponse>
)

data class BookMetaResponse(
    @SerializedName("total_count") val totalCount: Int,
    @SerializedName("pageable_count") val pageableCount: Int,
    @SerializedName("is_end") val isEnd: Boolean
)

@Parcelize
data class BookItemResponse(
    @SerializedName("title") val title: String,
    @SerializedName("contents") val contents: String,
    @SerializedName("url") val url: String,
    @SerializedName("isbn") val isbn: String,
    @SerializedName("datetime") val datetime: String,
    @SerializedName("authors") val authors: List<String>,
    @SerializedName("publisher") val publisher: String,
    @SerializedName("translators") val translators: List<String>,
    @SerializedName("price") val price: Int,
    @SerializedName("sale_price") val salePrice: Int,
    @SerializedName("thumbnail") val thumbnail: String,
    @SerializedName("status") val status: String
) : Parcelable