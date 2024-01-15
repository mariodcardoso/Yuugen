package br.com.mariodias.yuugen.shelves.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.mariodias.yuugen.shelves.data.ShelvesEntity


@Dao
interface ShelvesBooksDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(book: ShelvesEntity)

    @Query("SELECT * FROM shelves_table")
    fun getShelvesBooks(): List<ShelvesEntity>

    @Query("DELETE FROM shelves_table")
    fun clearAll() =  emptyList<ShelvesEntity>()

}