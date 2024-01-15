package br.com.mariodias.yuugen.shelves.data.model

data class ShelvesBooks (
    val id: String,
    val thumbnail: String? = "",
    val readingStatus: String,
    val isFavorite: Boolean = false
)