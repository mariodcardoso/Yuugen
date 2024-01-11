package br.com.mario.yuugen.search.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.mario.yuugen.R
import br.com.mario.yuugen.databinding.FragmentBookSearchBinding


class BookSearchFragment : Fragment() {

    private lateinit var binding: FragmentBookSearchBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentBookSearchBinding.inflate(inflater, container, false)
        return binding.root
    }


}