package br.com.mariodias.yuugen.search.presentation

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.mariodias.yuugen.bookdetails.BookDetailsActivity
import br.com.mariodias.yuugen.bookdetails.BookDetailsActivity.Companion.BOOK_DETAILS
import br.com.mariodias.yuugen.databinding.FragmentBookSearchBinding
import br.com.mariodias.yuugen.search.network.BookDetails
import br.com.mariodias.yuugen.shelves.data.ShelvesEntity
import dagger.hilt.android.AndroidEntryPoint
import java.io.Serializable

@AndroidEntryPoint
class BookSearchFragment : Fragment(), OnBookSearchClickListener, Serializable {

    private lateinit var binding: FragmentBookSearchBinding
    private val viewModel by viewModels<BookSearchViewModel>()

    private val navController by lazy { findNavController() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentBookSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?) = false

            override fun onQueryTextChange(query: String?): Boolean {
                query?.let { viewModel.searchBooks(query) }
                return false
            }
        })

        viewModel.items.observe(viewLifecycleOwner) { books ->
            binding.rcvSearch.apply {
                adapter = BookSearchAdapter(books, this@BookSearchFragment)
                layoutManager = LinearLayoutManager(activity)
            }
        }
    }

    override fun onAddBookClick(bookInfo: ShelvesEntity) {
        viewModel.addBookOnShelves(bookInfo)
    }

    override fun onBookClick(bookSearchResultData: BookDetails) {
        context?.let {
            startActivity(
                BookDetailsActivity.getStartIntent(it)
                    .putExtra(BOOK_DETAILS, bookSearchResultData)
            )
        }
    }

}

interface OnBookSearchClickListener {
    fun onAddBookClick(bookInfo: ShelvesEntity)
    fun onBookClick(bookSearchResultData: BookDetails)
}