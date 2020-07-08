package com.example.kotlinmovie.ui.main.home

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.kotlinmovie.R
import com.example.kotlinmovie.common.BaseFragment
import com.example.kotlinmovie.models.base.Resource.Status.*
import com.example.kotlinmovie.util.AppConstants
import com.example.kotlinmovie.util.SmartScrollListener
import com.example.kotlinmovie.viewmodels.ViewModelProviderFactory
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment : BaseFragment(), SmartScrollListener.OnSmartScrollListener {

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    @Inject
    lateinit var requestManager: RequestManager

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelProviderFactory).get(HomeViewModel::class.java)
    }

    private val adapter by lazy {
        HomeAdapter(requestManager)
    }

    private val smartScrollListener by lazy {
        SmartScrollListener(this)
    }

    override fun setUpContents(savedInstanceState: Bundle?) {
        home_recycler.setHasFixedSize(true)
        home_recycler.layoutManager=LinearLayoutManager(mContext, RecyclerView.VERTICAL, false)

        home_recycler.adapter = adapter
        home_recycler.addOnScrollListener(smartScrollListener)

        subscribeMovieList();
    }

    private fun subscribeMovieList() {

        viewModel.observeMovies()
            .observe(this, Observer { resource ->
                when (resource.status) {

                    ERROR -> {
                        adapter.clearFooter()
                        showToastMsg(resource.message)
                    }

                    LOADING -> {
                        adapter.showLoading()
                    }

                    SUCCESS -> {
                        adapter.clearFooter()
//                        adapter.add(resource.data.results)
                        for (model in resource.data.results) {
                            adapter.add(model)
                        }
                    }
                }
            })
    }

    override fun getLayoutResource(): Int {
        return R.layout.fragment_home
    }

    override fun onListEndReach() {
        subscribeMovieList()
    }
}