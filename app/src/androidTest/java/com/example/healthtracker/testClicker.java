package com.example.healthtracker;

import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class testClicker {

    @Rule
    public ActivityTestRule<clickerActitivity> activityTestRule
            = new ActivityTestRule<>(clickerActitivity.class);

    @Test
    public void checkClickerActivity(){
        onView(withId(R.id.clickerCounter))
                .check(matches(isDisplayed()));

        onView(withId(R.id.clickerZone))
                .perform(click())
                .perform(click());

        onView(withId(R.id.clickerCounter))
                .check(matches(isDisplayed()))
                .check(matches(withText("1")));
    }

}
