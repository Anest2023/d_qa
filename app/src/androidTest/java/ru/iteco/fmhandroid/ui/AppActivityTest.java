package ru.iteco.fmhandroid.ui;


/*import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import static java.util.EnumSet.allOf;
import static java.util.regex.Pattern.matches;

import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;*/
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AppActivityTest {

    @Rule
    public ActivityTestRule<AppActivity> mActivityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Test
    public void appActivityTest() {
        ViewInteraction textInputEditText = onView(
                allOf(childAtPosition(
                                childAtPosition(
                                        withId(R.id.login_text_input_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText.perform(replaceText("login2"), closeSoftKeyboard());

        ViewInteraction textInputEditText2 = onView(
                allOf(childAtPosition(
                                childAtPosition(
                                        withId(R.id.password_text_input_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText2.perform(replaceText("password2"), closeSoftKeyboard());

        ViewInteraction materialButton = onView(
                allOf(withId(R.id.enter_button), withText("Sign in"), withContentDescription("Save"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.RelativeLayout")),
                                        1),
                                2),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction linearLayout = onView(
                allOf(withId(com.google.android.material.R.id.action_bar_root),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class))),
                        isDisplayed()));
        linearLayout.check(matches(isDisplayed()));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
