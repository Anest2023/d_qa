package ru.iteco.fmhandroid.ui


import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.anything
import org.hamcrest.Matchers.`is`
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.iteco.fmhandroid.R

@LargeTest
@RunWith(AndroidJUnit4::class)
class AppActivityTest2 {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(AppActivity::class.java)

    @Test
    fun appActivityTest2() {
        val textInputEditText = onView(
            allOf(
                childAtPosition(
                    childAtPosition(
                        withId(R.id.login_text_input_layout),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText.perform(replaceText("login2"), closeSoftKeyboard())

        val textInputEditText2 = onView(
            allOf(
                childAtPosition(
                    childAtPosition(
                        withId(R.id.password_text_input_layout),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText2.perform(replaceText("password2"), closeSoftKeyboard())

        val materialButton = onView(
            allOf(
                withId(R.id.enter_button), withText("Sign in"), withContentDescription("Save"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.RelativeLayout")),
                        1
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        materialButton.perform(click())

        val appCompatImageButton = onView(
            allOf(
                withId(R.id.main_menu_image_button), withContentDescription("Main menu"),
                childAtPosition(
                    allOf(
                        withId(R.id.container_custom_app_bar_include_on_fragment_main),
                        childAtPosition(
                            withClassName(`is`("android.widget.LinearLayout")),
                            0
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatImageButton.perform(click())

        val materialTextView = onView(
            allOf(
                withId(android.R.id.title), withText("News"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        materialTextView.perform(click())

        val recyclerView = onView(
            allOf(
                withId(R.id.news_list_recycler_view),
                childAtPosition(
                    withId(R.id.all_news_cards_block_constraint_layout),
                    0
                )
            )
        )
        recyclerView.perform(actionOnItemAtPosition<ViewHolder>(1, click()))

        val recyclerView2 = onView(
            allOf(
                withId(R.id.news_list_recycler_view),
                childAtPosition(
                    withId(R.id.all_news_cards_block_constraint_layout),
                    0
                )
            )
        )
        recyclerView2.perform(actionOnItemAtPosition<ViewHolder>(1, click()))

        val materialButton2 = onView(
            allOf(
                withId(R.id.edit_news_material_button),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.container_list_news_include),
                        0
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        materialButton2.perform(click())

        val materialButton3 = onView(
            allOf(
                withId(R.id.add_news_image_view), withContentDescription("Add news button"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.LinearLayout")),
                        1
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        materialButton3.perform(click())

        val materialAutoCompleteTextView = onView(
            allOf(
                withId(R.id.news_item_category_text_auto_complete_text_view),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.news_item_category_text_input_layout),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        materialAutoCompleteTextView.perform(click())

        val materialTextView2 = onData(anything())
            .inAdapterView(
                childAtPosition(
                    withClassName(`is`("android.widget.PopupWindow$PopupBackgroundView")),
                    0
                )
            )
            .atPosition(0)
        materialTextView2.perform(click())

        val textInputEditText3 = onView(
            allOf(
                withId(R.id.news_item_title_text_input_edit_text), withText("Объявление"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.news_item_title_text_input_layout),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        textInputEditText3.perform(replaceText("Объявление Новое"))

        val textInputEditText4 = onView(
            allOf(
                withId(R.id.news_item_title_text_input_edit_text), withText("Объявление Новое"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.news_item_title_text_input_layout),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        textInputEditText4.perform(closeSoftKeyboard())

        val textInputEditText5 = onView(
            allOf(
                withId(R.id.news_item_publish_date_text_input_edit_text),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.news_item_create_date_text_input_layout),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        textInputEditText5.perform(click())

        val materialButton4 = onView(
            allOf(
                withId(android.R.id.button1), withText("OK"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.ScrollView")),
                        0
                    ),
                    3
                )
            )
        )
        materialButton4.perform(scrollTo(), click())

        val textInputEditText6 = onView(
            allOf(
                withId(R.id.news_item_publish_time_text_input_edit_text),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.news_item_publish_time_text_input_layout),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        textInputEditText6.perform(click())

        val materialButton5 = onView(
            allOf(
                withId(android.R.id.button1), withText("OK"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.ScrollView")),
                        0
                    ),
                    3
                )
            )
        )
        materialButton5.perform(scrollTo(), click())

        val textInputEditText7 = onView(
            allOf(
                withId(R.id.news_item_description_text_input_edit_text),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.news_item_description_text_input_layout),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText7.perform(replaceText("ночь"), closeSoftKeyboard())

        val materialButton6 = onView(
            allOf(
                withId(R.id.save_button), withText("Save"), withContentDescription("Save"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("com.google.android.material.card.MaterialCardView")),
                        0
                    ),
                    6
                )
            )
        )
        materialButton6.perform(scrollTo(), click())

        val appCompatImageButton2 = onView(
            allOf(
                withId(R.id.main_menu_image_button), withContentDescription("Main menu"),
                childAtPosition(
                    allOf(
                        withId(R.id.container_custom_app_bar_include_on_fragment_news_control_panel),
                        childAtPosition(
                            withClassName(`is`("android.widget.LinearLayout")),
                            0
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatImageButton2.perform(click())

        val materialTextView3 = onView(
            allOf(
                withId(android.R.id.title), withText("News"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        materialTextView3.perform(click())

        val recyclerView3 = onView(
            allOf(
                withId(R.id.news_list_recycler_view),
                childAtPosition(
                    withId(R.id.all_news_cards_block_constraint_layout),
                    0
                )
            )
        )
        recyclerView3.perform(actionOnItemAtPosition<ViewHolder>(0, click()))

        val recyclerView4 = onView(
            allOf(
                withId(R.id.news_list_recycler_view),
                childAtPosition(
                    withId(R.id.all_news_cards_block_constraint_layout),
                    0
                )
            )
        )
        recyclerView4.perform(actionOnItemAtPosition<ViewHolder>(0, click()))
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
