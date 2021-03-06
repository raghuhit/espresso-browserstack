package com.sample.browserstack.samplecalculator;

import android.support.test.filters.MediumTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Espresso tests to ensure that random operation result are
 * handled correctly and correct output is generated and the
 * editText box is updated correctly
 */


@MediumTest
@RunWith(AndroidJUnit4.class)
public class EnsureRandomTests {

    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void testZeroMultiplication() {
        onView(withId(R.id.buttonTwo)).perform(click());
        onView(withId(R.id.buttonMultiply)).perform(click());
        onView(withId(R.id.buttonZero)).perform(click());
        onView(withId(R.id.buttonEqual)).perform(click());
        onView(withId(R.id.editText)).check(matches(withText("0")));
    }

    @Test
    public void testZeroDivision() {
        onView(withId(R.id.buttonTwo)).perform(click());
        onView(withId(R.id.buttonDivide)).perform(click());
        onView(withId(R.id.buttonZero)).perform(click());
        onView(withId(R.id.buttonEqual)).perform(click());
        onView(withId(R.id.editText)).check(matches(withText("∞")));
    }

}
