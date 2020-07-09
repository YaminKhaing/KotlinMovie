package com.example.kotlinmovie.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.example.kotlinmovie.R
import com.example.kotlinmovie.common.BaseActivity
import com.example.kotlinmovie.models.MovieInfoModel
import com.example.kotlinmovie.util.AppConstants
import com.example.kotlinmovie.viewmodels.ViewModelProviderFactory
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.home_item_layout.view.*
import java.lang.System.load
import javax.inject.Inject

class DetailActivity : BaseActivity() {

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    @Inject
    lateinit var requestManager: RequestManager

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelProviderFactory).get(DetailViewModel::class.java)
    }

    private lateinit var movieInfoModel: MovieInfoModel

    companion object{
        val IE_MODEl="movie_model"
        fun getIntent(context: Context, movieInfoModel: MovieInfoModel) : Intent{
            return Intent(context, DetailActivity::class.java).apply { putExtra(IE_MODEl, movieInfoModel) }
        }
    }

    override fun getLayoutResource(): Int {
        return R.layout.activity_detail
    }

    override fun setUpContents(savedInstanceState: Bundle?) {
//        setupToolbarColored(true)
        setupToolbarText("Detail")
        movieInfoModel = intent.getSerializableExtra(DetailActivity.IE_MODEl) as MovieInfoModel


        getMovieDetails()
    }

    private fun getMovieDetails() {
        Toast.makeText(this, "on click", Toast.LENGTH_SHORT).show()

        movie_title_id.text = movieInfoModel.title
        movie_overview_id.text=movieInfoModel.overview

//        Glide.(AppConstants.BASE_IMG_URL + movieInfoModel.poster_path)
//            .into(movie_poster_id)
        requestManager.load(AppConstants.BASE_IMG_URL + movieInfoModel.poster_path)
            .into(movie_poster_id)
    }
}