package com.ibtikar.mvvm_starter_koin_coroutines.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.math.BigInteger

/**
 * Created by Meslmawy on 6/10/2021
 */

@Parcelize
data class ArticleModelResponse(
    val uri : String,
    val url : String,
    val id : BigInteger,
    val asset_id : BigInteger,
    val source : String,
    val published_date : String,
    val updated : String,
    val section : String,
    val subsection : String,
    val nytdsection : String,
    val adx_adx_keywordswords : String,
    val column : String,
    val byline : String,
    val type : String,
    val title : String,
    val abstract : String,
    val media : List<MediaArticleItemResponse>,
) : Parcelable {
    fun imageUrl(): String? {
        return if(media.isNotEmpty())
            media[0].mediaMetaDataResponse?.get(2)?.url
        else
            ""
    }
}