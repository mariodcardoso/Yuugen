package br.com.mariodias.yuugen.search.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.mariodias.yuugen.search.network.BookSearchResult
import br.com.mariodias.yuugen.search.network.BookSearchResultService
import br.com.mariodias.yuugen.shelves.data.ShelvesDao
import br.com.mariodias.yuugen.shelves.data.ShelvesEntity
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

    fun addBookOnShelves(bookInfo: ShelvesEntity) {
//        shelvesDao.insert(bookInfo)
        Timber.i("MDCN - Livro inserido")
    }

}