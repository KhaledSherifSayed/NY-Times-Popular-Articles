package com.ibtikar.mvvm_starter_koin_coroutines.articleDetails


import androidx.test.rule.ActivityTestRule
import com.ibtikar.mvvm_starter_koin_coroutines.scenarios.ArticleDetailsScreenScenario
import com.ibtikar.mvvm_starter_koin_coroutines.scenarios.ArticleListAndDetailsScreenScenario
import com.ibtikar.mvvm_starter_koin_coroutines.ui.MainActivity
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test

/**
 * Created by Meslmawy on 2/8/2021
 */
class ArticleDetailsScreenTest : TestCase() {

    @get:Rule
    val activityTestRule = ActivityTestRule(MainActivity::class.java, true, false)

    @Test
    fun article_list_test_case() = run {
        before {
            activityTestRule.launchActivity(null)
        }.after {

        }.run {
            step("show article list") {
                scenario(ArticleListAndDetailsScreenScenario())
            }
            step("show actor details") {
                scenario(ArticleDetailsScreenScenario())
            }
        }
    }

}
