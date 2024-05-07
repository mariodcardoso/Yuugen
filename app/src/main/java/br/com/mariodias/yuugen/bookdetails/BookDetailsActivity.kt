package br.com.mariodias.yuugen.bookdetails

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.mariodias.yuugen.databinding.ActivityBookDetailsBinding
import br.com.mariodias.yuugen.search.network.BookDetails
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import java.io.Serializable

class BookDetailsActivity : AppCompatActivity(), Serializable {

    private val binding by lazy { ActivityBookDetailsBinding.inflate(layoutInflater) }
    private val bookDetails by lazy { intent.getSerializableExtra(BOOK_DETAILS) as BookDetails }

    companion object {

        const val BOOK_DETAILS = "BOOK_DETAILS"

        fun getStartIntent(context: Context): Intent {
            return Intent(context, BookDetailsActivity::class.java)
        }


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        bindBookDetails()


    }

    private fun bindBookDetails() {
        binding.apply {
            txtBookTitle.text = bookDetails.volumeInfo.title
            txtBookSummary.text = bookDetails.volumeInfo.description
            txtBookAuthor.text = bookDetails.volumeInfo.authors.toString()
            bookRating.rating = bookDetails.volumeInfo.averageRating

            Glide.with(this@BookDetailsActivity)
                .load(bookDetails.volumeInfo.imagesLinks?.thumbnail)
                .transform(RoundedCorners(40))
                .into(imgBookCover)


        }
    }
}