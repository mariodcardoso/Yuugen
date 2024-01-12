package br.com.mariodias.yuugen.shelves.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.mariodias.yuugen.R

/**
 * A simple [Fragment] subclass.
 * Use the [ShelvesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShelvesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shelves, container, false)
    }

}