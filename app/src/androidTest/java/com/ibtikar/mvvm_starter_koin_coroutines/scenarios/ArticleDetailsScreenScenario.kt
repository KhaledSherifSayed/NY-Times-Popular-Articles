package com.ibtikar.mvvm_starter_koin_coroutines.scenarios

import com.ibtikar.mvvm_starter_koin_coroutines.articleDetails.ArticleDetailsScreen
import com.kaspersky.kaspresso.testcases.api.scenario.Scenario
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext

/**
 * Created by Meslmawy on 2/8/2021
 */
class ArticleDetailsScreenScenario : Scenario() {

    val detailsScreen = ArticleDetailsScreen()

    override val steps: TestContext<Unit>.() -> Unit = {

        detailsScreen {

            step("make sure first item is visible and has data") {
                name {
                    isVisible()
                    hasAnyText()
                }
                image {
                    isVisible()
                }
                knonw_as {
                    isVisible()
                }
            }
        }
    }
}