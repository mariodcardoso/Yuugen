package br.com.mariodias.yuugen.shelves.presentation

import androidx.lifecycle.ViewModel
import br.com.mariodias.yuugen.shelves.data.ShelvesDao
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ShelvesViewModel @Inject constructor(private val shelvesDao: ShelvesDao) : ViewModel() {

    fun getBooksFromShelves() = shelvesDao.getBookListOnShelves()


}