package br.com.mariodias.yuugen.base

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.mariodias.yuugen.shelves.data.ShelvesDao
import br.com.mariodias.yuugen.shelves.data.ShelvesEntity

@Database(entities = [ShelvesEntity::class], version = 1, exportSchema = false)
abstract class YuugenDatabase : RoomDatabase() {

    abstract fun shelvesDao(): ShelvesDao
}