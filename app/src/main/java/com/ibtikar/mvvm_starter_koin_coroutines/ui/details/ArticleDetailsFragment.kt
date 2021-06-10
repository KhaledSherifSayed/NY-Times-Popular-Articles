package com.ibtikar.mvvm_starter_koin_coroutines.ui.details

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.navArgs
import com.ibtikar.mvvm_starter_koin_coroutines.R
import com.ibtikar.mvvm_starter_koin_coroutines.data.models.ArticleModelResponse
import com.ibtikar.mvvm_starter_koin_coroutines.databinding.ArticleDetailsFragmentBinding
import com.ibtikar.mvvm_starter_koin_coroutines.ui.base.BaseFragment
import com.ibtikar.mvvm_starter_koin_coroutines.ui.base.ViewState
import org.koin.androidx.viewmodel.ext.android.viewModel

class ArticleDetailsFragment : BaseFragment<ArticleDetailsFragmentBinding, ArticleDetailsViewModel>(R.layout.article_details_fragment) {

    private val args: ArticleDetailsFragmentArgs by navArgs()
    private lateinit var actorDetails: ArticleModelResponse

    override val viewModel: ArticleDetailsViewModel by viewModel()

    override fun setup() {
        (activity as AppCompatActivity?)!!.setSupportActionBar(binder.detailToolbar)
        (activity as AppCompatActivity?)!!.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        actorDetails = args.article
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = actorDetails.title
        binder.apply {
            this.article = actorDetails
        }
    }

    override fun render(state: ViewState) {

    }

}