package com.hello.espresso;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.squareup.spoon.Spoon;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.action.ViewActions.typeTextIntoFocusedView;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityRuleTest {

   @Rule
   public ActivityTestRule<LoginActivity> mActivityRule = new ActivityTestRule<LoginActivity>(LoginActivity.class);

    private LoginActivity loginActivity;
    public static final String  INVALID_LOGIN_MESSAGE = "Username/Password incorrect, please try again." ;
    public static String welcomeMsg = "Welcome to Main view.";
    @Before
    public void setActivity() {
        loginActivity = mActivityRule.getActivity();
    }


    @Test
    public void testValidLogin() {
        Spoon.screenshot(loginActivity, "before_testValidLogin");
        String userName = "hellotech";
        String password = "hellotech";
        onView(withId(R.id.usernameEditText)).perform(typeText(userName), closeSoftKeyboard());
        onView(withId(R.id.passwordEditText)).perform(typeText(password), closeSoftKeyboard());
        onView(withId(R.id.loginButton)).perform(click());

       // Assert.assertFalse(INVALID_LOGIN_MESSAGE.equals(msgTextView.getText().toString()));

        onView(withId(R.id.textView)).check(matches(withText(welcomeMsg)));


        Spoon.screenshot(loginActivity, "testValidLogin");
    }
}
