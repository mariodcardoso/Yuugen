package br.com.mariodias.yuugen.shelves.domain.repository

import br.com.mariodias.yuugen.shelves.data.model.ShelvesBooks

interface ShelvesBooksRepository {

    suspend fun getBooksFromShelves(): List<ShelvesBooks>

}