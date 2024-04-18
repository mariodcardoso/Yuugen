package br.com.mariodias.yuugen.readinghistory.domain.repository

import br.com.mariodias.yuugen.readinghistory.data.ReadingHistoryDao
import br.com.mariodias.yuugen.readinghistory.data.toReadingHistoryEntity
import br.com.mariodias.yuugen.readinghistory.model.ReadingHistory
import java.util.stream.Collectors
import javax.inject.Inject

class ReadingHistoryRepositoryImpl @Inject constructor(val dao: ReadingHistoryDao) : ReadingHistoryRepository {

    override suspend fun insert(readingHistory: ReadingHistory) {
        dao.insert(readingHistory.toReadingHistoryEntity())
    }

    override suspend fun getAllReadingHistory() = dao.getAllReadingHistory()
        .stream()
        .map { ReadingHistory(it.bookId, it.insights, it.currentPage, it.totalPages, it.readingDate) }
        .collect(Collectors.toList())

}