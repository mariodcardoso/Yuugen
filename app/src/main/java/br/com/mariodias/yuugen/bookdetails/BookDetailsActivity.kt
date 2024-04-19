package br.com.mariodias.yuugen.bookdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.mariodias.yuugen.databinding.ActivityBookDetailsBinding

class BookDetailsActivity : Fragment() {

    private lateinit var binding: ActivityBookDetailsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ActivityBookDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }


}