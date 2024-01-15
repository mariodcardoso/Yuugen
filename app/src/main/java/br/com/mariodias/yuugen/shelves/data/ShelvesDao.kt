package br.com.mariodias.yuugen.shelves.data

import android.content.Context
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bumptech.glide.Glide
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext


@Dao
interface ShelvesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(book: ShelvesEntity)

    @Query("SELECT * FROM shelves_table")
    fun getBookListOnShelves(): List<ShelvesEntity>

    @Query("DELETE FROM shelves_table")
    fun clearAll() =  emptyList<ShelvesEntity>()

}