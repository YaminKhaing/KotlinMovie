package com.example.kotlinmovie.ui.main.home

import com.example.kotlinmovie.common.BaseDiffUtil
import com.example.kotlinmovie.common.Pageable

class HomeDiffUtil(
    override var mOldItemList: List<Pageable>?,
    override var mNewItemList: List<Pageable>?
) : BaseDiffUtil() {

    override fun areTheSame(oldItemPosition: kotlin.Int, newItemPosition: kotlin.Int): kotlin.Boolean {

        TODO("Not yet implemented")

    }
}