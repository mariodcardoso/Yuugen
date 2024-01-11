package br.com.mario.yuugen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.mario.yuugen.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupBottomNavView()

    }

    private fun setupBottomNavView() {
        binding.bottomNavView.apply {
            background = null
            menu.getItem(2).isEnabled = false
        }
    }
}