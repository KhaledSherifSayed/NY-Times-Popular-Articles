package com.ibtikar.mvvm_starter_koin_coroutines.viewModels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ibtikar.mvvm_starter_koin_coroutines.R
import com.ibtikar.mvvm_starter_koin_coroutines.data.models.AllArticlesResponse
import com.ibtikar.mvvm_starter_koin_coroutines.data.models.ArticleModelResponse
import com.ibtikar.mvvm_starter_koin_coroutines.ui.base.ViewState
import com.ibtikar.mvvm_starter_koin_coroutines.ui.articlesList.ArticlesRepository
import com.ibtikar.mvvm_starter_koin_coroutines.ui.articlesList.ArticlesViewModel
import com.ibtikar.mvvm_starter_koin_coroutines.ui.articlesList.ArticlesViewState
import com.ibtikar.mvvm_starter_koin_coroutines.utils.TestContextProvider
import com.ibtikar.mvvm_starter_koin_coroutines.utils.erros.ApplicationException
import com.ibtikar.mvvm_starter_koin_coroutines.utils.erros.ErrorType
import io.mockk.*
import io.mockk.impl.annotations.MockK
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.flow.flow
import org.junit.Before
import org.junit.Test
import org.junit.Rule
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by Meslmawy on 6/10/2021
 */

@RunWith(MockitoJUnitRunner::class)
class ArticlesViewModelTest {

    @get:Rule
    var testRule: TestRule = InstantTaskExecutorRule()

    @MockK
    lateinit var repository: ArticlesRepository

    private lateinit var viewModel: ArticlesViewModel

    private val contextProvidersTest = TestContextProvider()

    private val dummyActors =
        listOf<ArticleModelResponse>(mockk(), mockk(), mockk(), mockk(), mockk())

    private val dummyException = ApplicationException(
        type = ErrorType.Unexpected,
        errorMessageRes = R.string.error_unexpected
    )

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        viewModel = ArticlesViewModel(contextProvidersTest, repository)
    }

    @Test
    fun `get articles change view state to LOADED if there is articles`() {
        val resultActors = AllArticlesResponse("test", "test", 0, results = dummyActors)
        coEvery { repository.getArticleList() } returns flow {
            emit(resultActors)
        }
        viewModel.getMostSharedArticles()
        assertEquals(viewModel.state.value, ArticlesViewState.onArticlesResponse(dummyActors))
    }

    @Test
    fun `get articles change view state to EMPTY if there is no articles`() {
        val resultActors = AllArticlesResponse("test", "test", 0, results = arrayListOf())
        coEvery { repository.getArticleList() } returns flow {
            emit(resultActors)
        }
        viewModel.getMostSharedArticles()
        assertEquals(viewModel.state.value, ViewState.Empty)
    }

    @Test
    fun `get articles change view state to ERROR if repository throws an error`() {
        coEvery { repository.getArticleList() } throws dummyException
        viewModel.getMostSharedArticles()
        assertEquals(
            viewModel.state.value,
            ViewState.Error(
                ApplicationException(
                    ErrorType.Unexpected,
                    errorMessageRes = dummyException.errorMessageRes
                )
            )
        )
    }
}
