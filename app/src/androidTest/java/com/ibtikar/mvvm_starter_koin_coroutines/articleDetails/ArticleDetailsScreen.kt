package com.ibtikar.mvvm_starter_koin_coroutines.articleDetails


import com.agoda.kakao.common.views.KView
import com.agoda.kakao.image.KImageView
import com.agoda.kakao.text.KTextView
import com.ibtikar.mvvm_starter_koin_coroutines.R
import com.kaspersky.kaspresso.screens.KScreen

/**
 * Created by Meslmawy on 2/8/2021
 */

class ArticleDetailsScreen() : KScreen<ArticleDetailsScreen>()  {

    override val layoutId: Int = R.layout.article_details_fragment
    override val viewClass: Class<*> = ArticleDetailsScreen::class.java

    val image = KImageView { withId(R.id.profile_detail_background) }
    val name = KTextView { withId(R.id.detail_title) }
    val knonw_as = KView { withId(R.id.expand_text_view) }

}