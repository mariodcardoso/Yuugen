package br.com.mariodias.yuugen.shelves.domain.repository

import br.com.mariodias.yuugen.shelves.data.dao.ShelvesBooksDao
import br.com.mariodias.yuugen.shelves.data.model.ShelvesBooks
import java.util.stream.Collectors

class ShelvesBooksRepositoryImpl(val shelvesBooksDao: ShelvesBooksDao) : ShelvesBooksRepository {
    override suspend fun getBooksFromShelves() = shelvesBooksDao
        .getShelvesBooks()
        .stream()
        .map { ShelvesBooks(it.id, it.thumbnail, it.readingStatus, it.isFavorite) }
        .collect(Collectors.toList())

}
