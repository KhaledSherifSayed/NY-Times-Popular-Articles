package com.ibtikar.mvvm_starter_koin_coroutines.actorList

import android.view.View
import com.agoda.kakao.common.views.KView
import com.agoda.kakao.image.KImageView
import com.agoda.kakao.recycler.KRecyclerItem
import com.agoda.kakao.recycler.KRecyclerView
import com.agoda.kakao.text.KTextView
import com.ibtikar.mvvm_starter_koin_coroutines.R
import com.ibtikar.mvvm_starter_koin_coroutines.data.models.ActorModleRepsonse
import com.kaspersky.kaspresso.screens.KScreen
import org.hamcrest.Matcher

/**
 * Created by Meslmawy on 2/8/2021
 */

class ActorListScreen() : KScreen<ActorListScreen>()  {

    override val layoutId: Int = R.layout.home_fragment
    override val viewClass: Class<*> = ActorListScreen::class.java

    val itemsRecycler = KRecyclerView(
        builder = { withId(R.id.actorsRV) },
        itemTypeBuilder = { itemType(::Item) })

    class Item(parent: Matcher<View>) : KRecyclerItem<ActorModleRepsonse>(parent) {
        val name = KTextView(parent) { withId(R.id.item_poster_title) }
        val constraint = KView(parent) { withId(R.id.item_container_cons) }
        val image = KImageView(parent){withId(R.id.item_poster_post)}
    }

}