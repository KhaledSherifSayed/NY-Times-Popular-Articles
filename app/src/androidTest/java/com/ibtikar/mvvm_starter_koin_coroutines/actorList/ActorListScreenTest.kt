package com.ibtikar.mvvm_starter_koin_coroutines.actorList

import androidx.test.rule.ActivityTestRule
import com.ibtikar.mvvm_starter_koin_coroutines.scenarios.ActorListScreenScenario
import com.ibtikar.mvvm_starter_koin_coroutines.ui.MainActivity
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test

/**
 * Created by Meslmawy on 2/8/2021
 */
class ActorListScreenTest : TestCase() {

    @get:Rule
    val activityTestRule = ActivityTestRule(MainActivity::class.java, true, false)

    @Test
    fun actor_list_test_case() = run {
        before {
            activityTestRule.launchActivity(null)
        }.after {

        }.run {
            step("run actor list") {
                scenario(ActorListScreenScenario())
            }
        }
    }

    @Test
    fun actor_list_details_test_case() = run {
        before {
            activityTestRule.launchActivity(null)
        }.after {

        }.run {
            step("run actor list") {
                scenario(ActorListScreenScenario())
            }
        }
    }
}
