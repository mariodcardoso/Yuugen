package br.com.mariodias.yuugen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import br.com.mariodias.yuugen.databinding.ActivityMainBinding
import br.com.mariodias.yuugen.search.presentation.BookSearchFragment

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupBottomNavView()
        setupFab()

        replaceFragment(HomeFragment())

    }

    private fun setupBottomNavView() {
        binding.bottomNavView.apply {
            background = null
            menu.getItem(2).isEnabled = false
            setOnItemSelectedListener { menuItem ->
                binding.fabSearch.isEnabled = true
                when (menuItem.itemId) {
                    R.id.home -> replaceFragment(HomeFragment())
                    R.id.shelves -> replaceFragment(ShelvesFragment())
                }
                true
            }
        }
    }

    private fun setupFab() {
        binding.fabSearch.setOnClickListener {fabSearch ->
            supportFragmentManager.beginTransaction().replace(binding.fragmentContainer.id, BookSearchFragment()).commit()
            fabSearch.isEnabled = false

        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(binding.fragmentContainer.id, fragment).commit()
    }

}