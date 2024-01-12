package br.com.mariodias.yuugen.search.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.mariodias.yuugen.search.database.BookSearchResult
import br.com.mariodias.yuugen.search.database.BookSearchResultService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber

class BookSearchViewModel : ViewModel() {

    private val service = BookSearchResultService()
    private val _items = MutableLiveData<BookSearchResult>()
    val items: LiveData<BookSearchResult>
        get() = _items

    fun searchBooks(bookName: String) {
        viewModelScope.launch {
            val result = service.getBooks(bookName)

            if (result.isSuccessful) {
                withContext(Dispatchers.Main) {
                    Timber.i("TotalItems - ${result.body()?.totalItems}")
                    _items.postValue(result.body())
                }
            }

        }
    }

}