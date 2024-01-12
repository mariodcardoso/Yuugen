package br.com.mariodias.yuugen.search.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.mariodias.yuugen.databinding.FragmentBookSearchBinding


class BookSearchFragment : Fragment() {

    private lateinit var binding: FragmentBookSearchBinding
    private val viewModel by viewModels<BookSearchViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentBookSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {
                query?.let { viewModel.searchBooks(query) }
                return false
            }
        })

        viewModel.items.observe(viewLifecycleOwner) { books ->
            binding.rcvSearch.apply {
                adapter = BookSearchAdapter(books)
                layoutManager = LinearLayoutManager(activity)
            }
        }

    }
}