package com.ibtikar.mvvm_starter_koin_coroutines.articleList

import android.view.View
import com.agoda.kakao.common.views.KView
import com.agoda.kakao.image.KImageView
import com.agoda.kakao.recycler.KRecyclerItem
import com.agoda.kakao.recycler.KRecyclerView
import com.agoda.kakao.text.KTextView
import com.ibtikar.mvvm_starter_koin_coroutines.R
import com.ibtikar.mvvm_starter_koin_coroutines.data.models.ArticleModelResponse
import com.kaspersky.kaspresso.screens.KScreen
import org.hamcrest.Matcher

/**
 * Created by Meslmawy on 2/8/2021
 */

class ArticleListScreen() : KScreen<ArticleListScreen>()  {

    override val layoutId: Int = R.layout.article_list_fragment
    override val viewClass: Class<*> = ArticleListScreen::class.java

    val itemsRecycler = KRecyclerView(
        builder = { withId(R.id.articlesRV) },
        itemTypeBuilder = { itemType(::Item) })

    class Item(parent: Matcher<View>) : KRecyclerItem<ArticleModelResponse>(parent) {
        val name = KTextView(parent) { withId(R.id.item_article_title) }
        val constraint = KView(parent) { withId(R.id.item_container_cons) }
        val image = KImageView(parent){withId(R.id.item_article_poster)}
    }

}