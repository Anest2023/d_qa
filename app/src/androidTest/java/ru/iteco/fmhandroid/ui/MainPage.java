package ru.iteco.fmhandroid.ui;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import ru.iteco.fmhandroid.R;

public class MainPage {

    public void verifyMainScreenIsDisplayed() {
        onView(withId(R.id.container_custom_app_bar_include_on_fragment_main));
    }


    public void clickOnFirstNews() {

        onView(withId(R.id.news_list_recycler_view))

                .perform(actionOnItemAtPosition(0, click()));
    }

    public void clickOnNewsAtPosition(int position) {

        onView(withId(R.id.news_list_recycler_view))

                .perform(actionOnItemAtPosition(position, click()));
    }
}
