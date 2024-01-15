package br.com.mariodias.yuugen.search.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.mariodias.yuugen.search.network.BookSearchResult
import br.com.mariodias.yuugen.search.network.BookSearchResultService
import br.com.mariodias.yuugen.shelves.data.ShelvesDao
import br.com.mariodias.yuugen.shelves.data.ShelvesEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class BookSearchViewModel @Inject constructor(val shelvesDao: ShelvesDao): ViewModel() {

    private val service = BookSearchResultService()
    private val _items = MutableLiveData<BookSearchResult>()
    val items: LiveData<BookSearchResult>
        get() = _items

    fun searchBooks(bookName: String) {
        viewModelScope.launch {
            val result = service.getBooks(bookName)

            if (result.isSuccessful) {
                withContext(Dispatchers.Main) {
                    _items.postValue(result.body())
                }
            }

        }
    }

    fun addBookOnShelves(bookInfo: ShelvesEntity) {
        shelvesDao.insert(bookInfo)
        Timber.i("MDCN - Livro inserido")
    }

}