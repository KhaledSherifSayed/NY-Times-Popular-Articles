package com.ibtikar.mvvm_starter_koin_coroutines.scenarios

import com.ibtikar.mvvm_starter_koin_coroutines.actorList.ActorListScreen
import com.kaspersky.kaspresso.testcases.api.scenario.Scenario
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.kotlintest.matchers.numerics.shouldBeGreaterThan

/**
 * Created by Meslmawy on 2/8/2021
 */
class ActorListAndDetailsScreenScenario : Scenario() {

    val listScreen = ActorListScreen()

    override val steps: TestContext<Unit>.() -> Unit = {

        listScreen {
            step("check actors list") {
                itemsRecycler {
                    step("size should be bigger than 0") {
                        getSize().shouldBeGreaterThan(0)
                    }

                    step("make sure first item is visible and has data") {
                        childAt<ActorListScreen.Item>(0) {
                            name {
                                isVisible()
                                hasAnyText()
                            }
                            image {
                                isVisible()
                            }
                            constraint{
                                 click()
                            }
                        }
                    }
                }
            }
        }

    }
}