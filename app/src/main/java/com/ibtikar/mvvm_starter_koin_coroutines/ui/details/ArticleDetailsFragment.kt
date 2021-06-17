package com.ibtikar.mvvm_starter_koin_coroutines.ui.details

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.navArgs
import com.ibtikar.mvvm_starter_koin_coroutines.R
import com.ibtikar.mvvm_starter_koin_coroutines.data.models.ArticleModelResponse
import com.ibtikar.mvvm_starter_koin_coroutines.databinding.ArticleDetailsFragmentBinding
import com.ibtikar.mvvm_starter_koin_coroutines.ui.base.BaseFragment


class ArticleDetailsFragment :
    BaseFragment<ArticleDetailsFragmentBinding>(R.layout.article_details_fragment) {

    private val args: ArticleDetailsFragmentArgs by navArgs()
    private lateinit var articleDetails: ArticleModelResponse

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity.let {
            (it as AppCompatActivity?)?.setSupportActionBar(binder.detailToolbar)
            (it as AppCompatActivity?)?.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            articleDetails = args.article
            (it as AppCompatActivity?)!!.supportActionBar!!.title =  articleDetails.title
        }
        binder.apply {
            this.article = articleDetails
        }
    }
}