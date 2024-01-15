package br.com.mariodias.yuugen.shelves.presentation

import android.content.Context
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.mariodias.yuugen.shelves.data.ShelvesDao
import br.com.mariodias.yuugen.shelves.data.ShelvesEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ShelvesViewModel @Inject constructor(private val shelvesDao: ShelvesDao) : ViewModel(), LifecycleObserver {

    private val _booksShelvesList = MutableLiveData<List<ShelvesEntity>>()
    val bookShelvesList: LiveData<List<ShelvesEntity>>
        get() = _booksShelvesList

    fun getBooksFromShelves() {
        _booksShelvesList.postValue(shelvesDao.getBookListOnShelves())
    }

    fun clearAll(context: Context) {
        _booksShelvesList.postValue(shelvesDao.clearAll())
    }
}