package br.com.mariodias.yuugen.base

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.mariodias.yuugen.readinghistory.data.ReadingHistoryDao
import br.com.mariodias.yuugen.readinghistory.data.ReadingHistoryEntity
import br.com.mariodias.yuugen.shelves.data.dao.ShelvesBooksDao
import br.com.mariodias.yuugen.shelves.data.ShelvesEntity

@Database(entities = [ShelvesEntity::class, ReadingHistoryEntity::class], version = 2, exportSchema = false)
abstract class YuugenDatabase : RoomDatabase() {

    abstract fun shelvesDao(): ShelvesBooksDao
    abstract fun readingHistory(): ReadingHistoryDao
}