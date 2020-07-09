package com.example.kotlinmovie.ui.main.home

import android.content.Context
import android.content.Intent.getIntent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.kotlinmovie.R
import com.example.kotlinmovie.common.BaseAdapter
import com.example.kotlinmovie.models.MovieInfoModel
import com.example.kotlinmovie.models.MovieListModel
import com.example.kotlinmovie.ui.detail.DetailActivity
import com.example.kotlinmovie.util.AppConstants.Companion.BASE_IMG_URL
import kotlinx.android.synthetic.main.home_item_layout.view.*

class HomeAdapter(var requestManager: RequestManager) : BaseAdapter() {
    private val TAG = "HomeAdapter"

    override fun onCreateCustomHeaderViewHolder(
        parent: ViewGroup?,
        viewType: Int
    ): RecyclerView.ViewHolder ?{
        return null
    }

    override fun onBindCustomHeaderViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
    }

    override fun onCreateCustomViewHolder(
        parent: ViewGroup?,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.home_item_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindCustomViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        (holder as ViewHolder).bindView(itemsList[position] as MovieInfoModel)

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val context : Context = itemView.context

        fun bindView(model : MovieInfoModel) {

            requestManager.load(BASE_IMG_URL+ model.poster_path)
                .into(itemView.image_view)

//            itemView.text_view.setMyanmarText(model.title)

            itemView.setOnClickListener {
                context.startActivity(DetailActivity.getIntent(context, model))
//                Log.d(TAG, "bindView: ");
            }
        }
    }
}

