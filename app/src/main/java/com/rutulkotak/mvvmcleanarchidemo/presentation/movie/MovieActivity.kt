package com.rutulkotak.mvvmcleanarchidemo.presentation.movie

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rutulkotak.mvvmcleanarchidemo.R
import com.rutulkotak.mvvmcleanarchidemo.databinding.ActivityMovieBinding
import com.rutulkotak.mvvmcleanarchidemo.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {

    @Inject
    lateinit var movieViewModelFactory: MovieViewModelFactory
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var binding: ActivityMovieBinding
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setup()
        initUI()
        displayMovies()
    }

    private fun setup() {
        (application as Injector).createMovieSubComponent().inject(this)
        movieViewModel = ViewModelProvider(this, movieViewModelFactory)[MovieViewModel::class.java]
    }

    private fun initUI() {
        binding.movieRecyclerView.layoutManager = LinearLayoutManager(this)
        movieAdapter = MovieAdapter()
        binding.movieRecyclerView.adapter = movieAdapter
    }

    private fun displayMovies() {
        movieViewModel.getMovies().observe(this) {
            it?.let {
                it1 -> movieAdapter.setMovieList(it1)
                movieAdapter.notifyDataSetChanged()
            }
            binding.movieProgressBar.visibility = View.GONE
        }
    }
}