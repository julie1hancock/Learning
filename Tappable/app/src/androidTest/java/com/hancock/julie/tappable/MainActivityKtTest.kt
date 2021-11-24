package com.hancock.julie.tappable

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performGesture
import androidx.test.espresso.Espresso.onView
import com.hancock.julie.tappable.ui.theme.TappableTheme
import org.junit.Rule
import org.junit.Test
import androidx.test.espresso.action.CoordinatesProvider

import androidx.test.espresso.action.GeneralClickAction

import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.Press


class MainActivityKtTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    // use createAndroidComposeRule<YourActivity>() if you need access to
    // an activity

    @Test
    fun MyTest() {
        // Start the app
        composeTestRule.setContent {
            TappableTheme {
                ClickableBackground()
            }
        }
        composeTestRule.onRoot().performGesture {
            clickXY(50,50)
        }
    }
}


fun clickXY(x: Int, y: Int): ViewAction {
    return GeneralClickAction(
        androidx.test.espresso.action.Tap.SINGLE,
        { view ->
            val screenPos = IntArray(2)
            view.getLocationOnScreen(screenPos)
            val screenX = (screenPos[0] + x).toFloat()
            val screenY = (screenPos[1] + y).toFloat()
            floatArrayOf(screenX, screenY)
        },
        Press.FINGER
    )
}