package br.com.mariodias.yuugen.shelves.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface ShelvesDao {

    @Insert
    fun insert(book: ShelvesEntity)

    @Query("SELECT * FROM shelves_table")
    fun getBookListOnShelves(): List<ShelvesEntity>

}