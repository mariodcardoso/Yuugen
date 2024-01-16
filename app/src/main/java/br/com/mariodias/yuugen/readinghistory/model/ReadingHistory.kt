package br.com.mariodias.yuugen.readinghistory.model

data class ReadingHistory (
    val bookId: String,
    val insights: String,
    val currentPage: Int,
    val totalPages: Int,
    val readingDate: String
){

    fun getReadingPercentage(): Float = (totalPages / currentPage).toFloat()
}


