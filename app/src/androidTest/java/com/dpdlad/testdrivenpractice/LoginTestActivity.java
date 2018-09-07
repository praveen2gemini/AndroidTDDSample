package com.dpdlad.testdrivenpractice;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.dpdlad.testdrivenpractice.login.LoginActivity;
import com.dpdlad.testdrivenpractice.login.presenter.LoginPresenter;
import com.dpdlad.testdrivenpractice.login.presenter.LoginPresenterImpl;

import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * @author Praveen on 28/08/18.
 */
@RunWith(AndroidJUnit4.class)
public class LoginTestActivity {
    ActivityTestRule<LoginActivity> activityTestRule =
            new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void checkUserNameEditTextIsDisplayed() {
        activityTestRule.launchActivity(new Intent());
        onView(withId(R.id.edt_user_name)).check(matches(isDisplayed()));
    }

    @Test
    public void checkPasswordEditTextIsDisplayed() {
        activityTestRule.launchActivity(new Intent());
        onView(withId(R.id.edt_password)).check(matches(isDisplayed()));
    }

    @Test
    public void checkErrorMessageIsDisplayedForEmptyData() {
        activityTestRule.launchActivity(new Intent());
        onView(withId(R.id.btn_login)).check(matches(isDisplayed())).perform(click());
        onView(withText("Please check Username or Password.")).check(matches(isDisplayed()));
    }

    @Test
    public void checkLoginByPresenter() {
        activityTestRule.launchActivity(new Intent());
//        LoginPresenter.LoginViewNotifier notifier = activityTestRule.getActivity();
        LoginPresenter.LoginViewNotifier notifier = mock(LoginActivity.class);
        LoginPresenter loginPresenter = new LoginPresenterImpl(notifier);
        loginPresenter.doLoginWithCredentials("test", "test");
        verify(notifier).showLoginSuccessMessage();
    }


    @Test
    public void checkLoginSuccess() {
        activityTestRule.launchActivity(new Intent());
        onView(withId(R.id.edt_user_name)).perform(typeText("test"), closeSoftKeyboard());
        onView(withId(R.id.edt_password)).perform(typeText("test"), closeSoftKeyboard());
        onView(withId(R.id.btn_login)).check(matches(isDisplayed())).perform(click());
        onView(withText("Login successful.")).check(matches(isDisplayed()));
    }
}
