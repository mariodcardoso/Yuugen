package br.com.mariodias.yuugen.search.database

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BookSearchResultService {

    private val api: BookApi = Retrofit.Builder()
        .baseUrl("https://www.googleapis.com/books/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(BookApi::class.java)

    suspend fun getBooks(bookName: String): Response<BookSearchResult> = api.getBook(bookName)

}