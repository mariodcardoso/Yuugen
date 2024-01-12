package br.com.mariodias.yuugen.search.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BookApi {
    @GET("volumes")
    suspend fun getBook(@Query("q") bookName: String): Response<BookSearchResult>
}