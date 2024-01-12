package br.com.mariodias.yuugen.shelves.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shelves_table")
data class ShelvesEntity(
    @PrimaryKey
    val id: String,

    @ColumnInfo(name = "thumbnail")
    val thumbnail: String? = "",

    @ColumnInfo(name = "readingStatus")
    val readingStatus: String,

    @ColumnInfo(name = "isFavorite")
    val isFavorite: Boolean = false

)
