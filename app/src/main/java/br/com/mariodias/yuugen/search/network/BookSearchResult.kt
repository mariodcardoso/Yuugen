package br.com.mariodias.yuugen.search.network

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class BookSearchResult(
    @SerializedName("totalItems")
    val totalItems: Int,

    @SerializedName("items")
    val items: List<BookDetails>,
) : Serializable {

    fun getBookList() = items.sortedBy { it.volumeInfo.publishedDate }

}

data class BookDetails(
    @SerializedName("id")
    val id: String,

    @SerializedName("volumeInfo")
    val volumeInfo: VolumeInfo
) : Serializable

data class VolumeInfo(
    @SerializedName("title")
    val title: String? = " ",

    @SerializedName("authors")
    val authors: List<String>? = emptyList(),

    @SerializedName("publishedDate")
    val publishedDate: String? = " ",

    @SerializedName("imageLinks")
    val imagesLinks: ImageLinks?,

    @SerializedName("description")
    val description: String? = " ",

    @SerializedName("averageRating")
    val averageRating: Float = 0.0F,

    @SerializedName("ratingsCount")
    val ratingsCount: Int = 0,
) : Serializable

data class ImageLinks(
    @SerializedName("thumbnail")
    val thumbnail: String,

    @SerializedName("smallThumbnail")
    val smallThumbnail: String

) : Serializable
