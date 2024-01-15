package br.com.mariodias.yuugen.shelves.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import br.com.mariodias.yuugen.databinding.ItemBookShelvesBinding
import br.com.mariodias.yuugen.shelves.data.model.ShelvesBooks
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

class BookShalvesAdapter(private val booksFromShelvesList: List<ShelvesBooks>) : Adapter<BookShalvesAdapter.BookShelvesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookShelvesViewHolder {
        return BookShelvesViewHolder(
            ItemBookShelvesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount() = booksFromShelvesList.size

    override fun onBindViewHolder(holder: BookShelvesViewHolder, position: Int) {
        holder.bind(booksFromShelvesList[position])
    }

    inner class BookShelvesViewHolder(private val item: ItemBookShelvesBinding) : ViewHolder(item.root) {
        fun bind(booksFromShelvesList: ShelvesBooks) {

            Glide.with(this.itemView.context)
                .load(booksFromShelvesList.thumbnail)
                .error(
                    Glide.with(this.itemView.context)
                        .load("https://voice.global/wp-content/plugins/wbb-publications/public/assets/img/placeholder.jpg")
                )
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .transform(RoundedCorners(14))
                .into(item.imgBookCover)
        }

    }

}