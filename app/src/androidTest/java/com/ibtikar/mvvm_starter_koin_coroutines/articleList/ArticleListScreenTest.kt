package com.ibtikar.mvvm_starter_koin_coroutines.articleList

import androidx.test.rule.ActivityTestRule
import com.ibtikar.mvvm_starter_koin_coroutines.scenarios.ArticleListScreenScenario
import com.ibtikar.mvvm_starter_koin_coroutines.ui.MainActivity
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test

/**
 * Created by Meslmawy on 2/8/2021
 */

class ArticleListScreenTest : TestCase() {

    @get:Rule
    val activityTestRule = ActivityTestRule(MainActivity::class.java, true, false)

    @Test
    fun article_list_test_case() = run {
        before {
            activityTestRule.launchActivity(null)
        }.after {

        }.run {
            step("run article list") {
                scenario(ArticleListScreenScenario())
            }
        }
    }
}
