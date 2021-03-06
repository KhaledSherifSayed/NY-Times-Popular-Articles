package com.ibtikar.mvvm_starter_koin_coroutines.utils

import com.ibtikar.mvvm_starter_koin_coroutines.utils.coroutines.ContextProviders
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

/**
 * Created by Meslmawy on 6/10/2021
 */

class TestContextProvider : ContextProviders() {
    override val Main: CoroutineContext
        get() = Dispatchers.Unconfined
    override val IO: CoroutineContext
        get() = Dispatchers.Unconfined
}
