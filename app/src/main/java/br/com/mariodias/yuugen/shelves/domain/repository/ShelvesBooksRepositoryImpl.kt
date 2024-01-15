package br.com.mariodias.yuugen.shelves.domain.repository

import br.com.mariodias.yuugen.shelves.data.dao.ShelvesBooksDao
import br.com.mariodias.yuugen.shelves.data.model.ShelvesBooks
import java.util.stream.Collectors

class ShelvesBooksRepositoryImpl(private val dao: ShelvesBooksDao) : ShelvesBooksRepository {
    override suspend fun getBooksFromShelves() = dao
        .getShelvesBooks()
        .stream()
        .map { ShelvesBooks(it.id, it.thumbnail, it.readingStatus, it.isFavorite) }
        .collect(Collectors.toList())

    override suspend fun clearShelves(): List<ShelvesBooks> {
        dao.clearAll()
        return emptyList()
    }

}
