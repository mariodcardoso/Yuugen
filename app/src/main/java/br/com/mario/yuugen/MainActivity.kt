package br.com.mario.yuugen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import br.com.mario.yuugen.databinding.ActivityMainBinding
import br.com.mario.yuugen.search.presentation.BookSearchFragment

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupBottomNavView()
        setupFab()

        replaceFragment(BookSearchFragment())

    }

    private fun setupBottomNavView() {
        binding.bottomNavView.apply {
            background = null
            menu.getItem(2).isEnabled = false
            setOnItemSelectedListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.home -> replaceFragment(HomeFragment())
                    R.id.shelves -> replaceFragment(ShelvesFragment())
                }
                true
            }
        }
    }

    private fun setupFab() {
        binding.fabSearch.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(binding.fragmentContainer.id, BookSearchFragment()).commit()
        }
    }


    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(binding.fragmentContainer.id, fragment).commit()
    }

}