package br.com.mariodias.yuugen.shelves.presentation

import android.content.Context
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.mariodias.yuugen.shelves.data.model.ShelvesBooks
import br.com.mariodias.yuugen.shelves.domain.repository.ShelvesBooksRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShelvesViewModel @Inject constructor(private val shelvesBooksRepo: ShelvesBooksRepositoryImpl) : ViewModel(), DefaultLifecycleObserver {

    private val _shelvesBooksList = MutableLiveData<List<ShelvesBooks>>()


    override fun onCreate(owner: LifecycleOwner) {
        getBooksFromShelves()

        super.onCreate(owner)
    }

    val bookShelvesList: LiveData<List<ShelvesBooks>>
        get() = _shelvesBooksList

    private fun getBooksFromShelves() {
        viewModelScope.launch(Dispatchers.Main) {
            _shelvesBooksList.postValue(shelvesBooksRepo.getBooksFromShelves())
        }
    }

    fun clearAll(context: Context) {
        viewModelScope.launch(Dispatchers.Main) {
            _shelvesBooksList.postValue(shelvesBooksRepo.clearShelves())
        }
    }

}