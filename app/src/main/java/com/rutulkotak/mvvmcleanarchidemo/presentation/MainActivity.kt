package com.rutulkotak.mvvmcleanarchidemo.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.rutulkotak.mvvmcleanarchidemo.R
import com.rutulkotak.mvvmcleanarchidemo.databinding.ActivityMainBinding
import com.rutulkotak.mvvmcleanarchidemo.presentation.di.Injector
import com.rutulkotak.mvvmcleanarchidemo.presentation.movie.MovieViewModel
import com.rutulkotak.mvvmcleanarchidemo.presentation.movie.MovieViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var movieViewModelFactory: MovieViewModelFactory
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var biding: ActivityMainBinding
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        biding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        (application as Injector).createMovieSubComponent().inject(this)
        movieViewModel = ViewModelProvider(this, movieViewModelFactory).get(MovieViewModel::class.java)

        movieViewModel.getMovies().observe(this) {
            Log.d(TAG, it.toString())
        }
    }
}