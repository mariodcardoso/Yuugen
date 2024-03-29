package br.com.mariodias.yuugen.shelves.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import br.com.mariodias.yuugen.databinding.FragmentShelvesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShelvesFragment : Fragment() {

    private lateinit var binding: FragmentShelvesBinding
    private val viewModel by viewModels<ShelvesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        lifecycle.addObserver(viewModel)

        binding = FragmentShelvesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.bookShelvesList.observe(viewLifecycleOwner) { bookShelvesList ->
            binding.rcvShelves.apply {
                adapter = BookShalvesAdapter(bookShelvesList)
                layoutManager = GridLayoutManager(activity?.applicationContext, 3)
            }
        }

        binding.fabClearAll.setOnClickListener {
            viewModel.clearAll(this@ShelvesFragment.requireContext())
        }

    }
}