package br.com.mariodias.yuugen.readinghistory.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ReadingHistoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(readingHistoryEntity: ReadingHistoryEntity)

    @Query("SELECT * FROM reading_history_table")
    fun getAllReadingHistory(): List<ReadingHistoryEntity>


}