package com.ibtikar.mvvm_starter_koin_coroutines.repositories

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ibtikar.mvvm_starter_koin_coroutines.data.models.AllArticlesResponse
import com.ibtikar.mvvm_starter_koin_coroutines.data.network.ApiService
import com.ibtikar.mvvm_starter_koin_coroutines.ui.articlesList.ArticlesRepository
import com.ibtikar.mvvm_starter_koin_coroutines.utils.TestContextProvider
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.flow.collect
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner


/**
 * Created by Meslmawy on 2/8/2021
 */

@RunWith(MockitoJUnitRunner::class)
class ArticleRepositoryTest {


    @get:Rule
    var testRule: TestRule = InstantTaskExecutorRule()

    private val contextProvidersTest = TestContextProvider()

    @MockK
    lateinit var apiService: ApiService

    @MockK
    lateinit var successActorResponse: AllArticlesResponse

    lateinit var repository: ArticlesRepository

    @get:Rule
    var thrown: ExpectedException = ExpectedException.none()

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        repository = ArticlesRepository(contextProvidersTest,  apiService)
    }

    @Test
    fun `get articles list with success response`() = runBlocking {

        coEvery { apiService.getAllArticles() } returns successActorResponse

        repository.getArticleList().collect {
            assertEquals(it, successActorResponse)
        }

    }
}