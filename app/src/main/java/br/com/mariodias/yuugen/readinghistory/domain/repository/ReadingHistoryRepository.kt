package br.com.mariodias.yuugen.readinghistory.domain.repository

import br.com.mariodias.yuugen.readinghistory.model.ReadingHistory

interface ReadingHistoryRepository {

    suspend fun insert(readingHistory: ReadingHistory)

    suspend fun getAllReadingHistory(): List<ReadingHistory>

}