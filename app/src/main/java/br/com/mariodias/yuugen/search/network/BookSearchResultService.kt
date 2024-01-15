package br.com.mariodias.yuugen.search.network

import br.com.mariodias.yuugen.base.BookApi
import retrofit2.Response
import javax.inject.Inject

class BookSearchResultService @Inject constructor(val api: BookApi) {

    suspend fun getBooks(bookName: String): Response<BookSearchResult> = api.getBook(bookName)

}