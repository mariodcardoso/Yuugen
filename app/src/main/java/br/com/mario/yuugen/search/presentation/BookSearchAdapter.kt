package br.com.mario.yuugen.search.presentation

import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import br.com.mario.yuugen.R
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions


class BookSearchAdapter : Adapter<BookSearchAdapter.BookSearchViewHolder>() {

    val bookList = listOf<BookSearch>(
        BookSearch(
            R.drawable.placeholder_book_cover,
            "Harry Potter e a Pedra Filosofal",
            "J.K. Rowling",
            "2000"
        ),

        BookSearch(
            R.drawable.placeholder_book_cover,
            "Harry Potter e a Camara Secreta",
            "J.K. Rowling",
            "2001"
        ),

        BookSearch(
            R.drawable.placeholder_book_cover,
            "Harry Potter e o Prisioneiro de Azkaban",
            "J.K. Rowling",
            "2002"
        ),
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookSearchViewHolder {
        return BookSearchViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_book_search, parent, false))
    }

    override fun getItemCount() = bookList.size

    override fun onBindViewHolder(holder: BookSearchViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class BookSearchViewHolder(itemView: View) : ViewHolder(itemView) {

        private val cover = itemView.findViewById<ImageView>(R.id.img_book_cover)
        private val title = itemView.findViewById<TextView>(R.id.txt_book_title)
        private val author = itemView.findViewById<TextView>(R.id.txt_book_author)
        private val year = itemView.findViewById<TextView>(R.id.txt_book_released_year)

        fun bind(position: Int) {
            Glide
                .with(itemView.context)
                .load(R.drawable.placeholder_book_cover)
                .transform(RoundedCorners(18))

                .into(cover)


            title.text = bookList[position].title
            author.text = bookList[position].author
            year.text = bookList[position].year
        }
    }
}