package com.ibtikar.mvvm_starter_koin_coroutines.actorDetails


import androidx.test.rule.ActivityTestRule
import com.ibtikar.mvvm_starter_koin_coroutines.scenarios.ActorDetailsScreenScenario
import com.ibtikar.mvvm_starter_koin_coroutines.scenarios.ActorListAndDetailsScreenScenario
import com.ibtikar.mvvm_starter_koin_coroutines.ui.MainActivity
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test

/**
 * Created by Meslmawy on 2/8/2021
 */
class ActorDetailsScreenTest : TestCase() {

    @get:Rule
    val activityTestRule = ActivityTestRule(MainActivity::class.java, true, false)

    @Test
    fun actor_list_test_case() = run {
        before {
            activityTestRule.launchActivity(null)
        }.after {

        }.run {
            step("show actor list") {
                scenario(ActorListAndDetailsScreenScenario())
            }
            step("show actor details") {
                scenario(ActorDetailsScreenScenario())
            }
        }
    }

}
