package com.example.myfriends.signup

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.example.myfriends.MainActivity
import org.junit.Rule
import org.junit.Test

class SignUpTest {

    @get:Rule
    val signUpTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun performSignUp() {
        launchSignUpScreen(signUpTestRule) {
            typeEmail("akhil@gmail.com")
            typePassword("password")
            submit()
        } verify {
            timelineScreenIsPresent()
        }
    }

}