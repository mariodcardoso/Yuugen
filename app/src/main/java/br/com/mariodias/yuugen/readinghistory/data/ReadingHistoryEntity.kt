package br.com.mariodias.yuugen.readinghistory.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.mariodias.yuugen.readinghistory.model.ReadingHistory

@Entity(tableName = "reading_history_table")
data class ReadingHistoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    @ColumnInfo(name = "bookId")
    val bookId: String,

    @ColumnInfo(name = "insights")
    val insights: String,

    @ColumnInfo(name = "currentPage")
    val currentPage: Int,

    @ColumnInfo(name = "totalPages")
    val totalPages: Int,

    @ColumnInfo(name = "readingDate")
    val readingDate: String
)

fun ReadingHistory.toReadingHistory(): ReadingHistoryEntity {
    return ReadingHistoryEntity(
        bookId = this.bookId,
        insights = this.insights,
        currentPage = this.currentPage,
        totalPages = this.totalPages,
        readingDate = this.readingDate
    )
}