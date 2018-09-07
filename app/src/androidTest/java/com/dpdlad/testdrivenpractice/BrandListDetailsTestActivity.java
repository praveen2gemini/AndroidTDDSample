package com.dpdlad.testdrivenpractice;

import android.content.Intent;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.dpdlad.testdrivenpractice.brands.MobileBrandListActivity;
import com.dpdlad.testdrivenpractice.brands.adapter.MobileBrandAdapter;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * @author Praveen on 31/08/18.
 */

@RunWith(AndroidJUnit4.class)
public class BrandListDetailsTestActivity {
    ActivityTestRule<MobileBrandListActivity> activityTestRule = new ActivityTestRule<>(MobileBrandListActivity.class);

    @Test
    public void checkBrandFragmentIsDisplayed() {
        activityTestRule.launchActivity(new Intent());
        onView(withId(R.id.recycler_view))
                .perform(RecyclerViewActions.scrollToHolder(isInAppleBrand()));
    }

    /**
     * Matches the {@link MobileBrandAdapter.BrandHolder}s in the middle of the list.
     */
    private static Matcher<MobileBrandAdapter.BrandHolder> isInAppleBrand() {
        return new TypeSafeMatcher<MobileBrandAdapter.BrandHolder>() {
            @Override
            protected boolean matchesSafely(MobileBrandAdapter.BrandHolder customHolder) {
                return customHolder.getItemName().equalsIgnoreCase("Apple");
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("item in the middle");
            }
        };
    }
}
