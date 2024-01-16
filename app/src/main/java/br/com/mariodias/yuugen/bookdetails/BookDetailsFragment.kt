package br.com.mariodias.yuugen.bookdetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.mariodias.yuugen.R
import br.com.mariodias.yuugen.databinding.FragmentBookDetailsBinding

class BookDetailsFragment : Fragment() {

    private lateinit var binding: FragmentBookDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBookDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }


}