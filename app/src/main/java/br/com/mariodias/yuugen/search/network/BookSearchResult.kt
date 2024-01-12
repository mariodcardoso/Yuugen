package br.com.mariodias.yuugen.search.network

import com.google.gson.annotations.SerializedName


data class BookSearchResult(
    @SerializedName("totalItems")
    val totalItems: Int,

    @SerializedName("items")
    val items: List<BookDetails>,
) {

    fun getBookList() = items.sortedBy { it.volumeInfo.publishedDate }

}


data class BookDetails(
    @SerializedName("id")
    val id: String,

    @SerializedName("volumeInfo")
    val volumeInfo: VolumeInfo
)

data class VolumeInfo(
    @SerializedName("title")
    val title: String? = " ",

    @SerializedName("authors")
    val authors: List<String>? = emptyList(),

    @SerializedName("publishedDate")
    val publishedDate: String? = " ",

    @SerializedName("imageLinks")
    val imagesLinks: ImageLinks?
)

data class ImageLinks(
    @SerializedName("thumbnail")
    val thumbnail: String,

    @SerializedName("smallThumbnail")
    val smallThumbnail: String

)
