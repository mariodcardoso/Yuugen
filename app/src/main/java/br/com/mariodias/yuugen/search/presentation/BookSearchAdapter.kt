package br.com.mariodias.yuugen.search.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import br.com.mariodias.yuugen.databinding.ItemBookSearchBinding
import br.com.mariodias.yuugen.search.network.BookDetails
import br.com.mariodias.yuugen.search.network.BookSearchResult
import br.com.mariodias.yuugen.shelves.data.ShelvesEntity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.RoundedCorners


class BookSearchAdapter(
    private val data: BookSearchResult,
    val listener: OnBookSearchClickListener
) : Adapter<BookSearchAdapter.BookSearchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookSearchViewHolder {
        return BookSearchViewHolder(
            ItemBookSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount() = data.items.size

    override fun onBindViewHolder(holder: BookSearchViewHolder, position: Int) {
        holder.bind(data.getBookList()[position])
    }

    inner class BookSearchViewHolder(private val item: ItemBookSearchBinding) : ViewHolder(item.root) {

        fun bind(bookSearchResultData: BookDetails) {
            item.txtBookTitle.text = bookSearchResultData.volumeInfo.title
            item.txtBookAuthor.text = bookSearchResultData.volumeInfo.authors?.joinToString(", ")
            item.txtBookReleasedYear.text = bookSearchResultData.volumeInfo.publishedDate?.subSequence(0, 4)

            val thumb = bookSearchResultData.volumeInfo.imagesLinks?.thumbnail

            Glide.with(this.itemView.context)
                .load(thumb)
                .error(
                    Glide.with(this.itemView.context)
                        .load("https://voice.global/wp-content/plugins/wbb-publications/public/assets/img/placeholder.jpg")
                )
                .transform(RoundedCorners(18))
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .into(item.imgBookCover)

            item.btnAddBook.setOnClickListener {

                val bookInfo = ShelvesEntity(
                    id = bookSearchResultData.id,
                    thumbnail = bookSearchResultData.volumeInfo.imagesLinks?.thumbnail,
                    readingStatus = "Não iniciado",
                    isFavorite = false
                )

                listener.onAddBookClick(bookInfo)
            }

            item.root.setOnClickListener{
                listener.onBookClick(bookSearchResultData)
            }


        }
    }
}