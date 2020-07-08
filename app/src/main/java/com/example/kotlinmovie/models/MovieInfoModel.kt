package com.example.kotlinmovie.models

import androidx.room.Ignore
import com.example.kotlinmovie.common.Pageable
import java.io.Serializable

class MovieInfoModel() : Serializable, Pageable {

    var poster_path: String = ""
    var adult = false
    var overview: String = ""
    var release_date: String=""
    var genre_ids: IntArray? =null
    var id = 0
    var original_title: String= ""
    var original_language: String = ""
    var title: String = ""
    var backdrop_path: String = ""
    var popularity = 0
    var vote_count = 0
    var video = false
    var vote_average = 0

    @Ignore
    constructor(poster_path:String, adult:Boolean, overview:String, release_date:String, genre_ids:IntArray, id:Int, original_title:String,
    original_language:String, title:String, backdrop_path:String,popularity:Int,vote_count:Int, video:Boolean, vote_average:Int) : this(){
        this.poster_path=poster_path
        this.adult=adult
        this.overview=overview
        this.release_date=release_date
        this.genre_ids=genre_ids
        this.id=id
        this.original_title=original_title
        this.original_language=original_language
        this.title=title
        this.backdrop_path=backdrop_path
        this.popularity=popularity
        this.vote_count=vote_count
        this.video=video
        this.vote_average=vote_average
    }

}
