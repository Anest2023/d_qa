package ru.iteco.fmhandroid.ui;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

//import static java.util.EnumSet.allOf;
import static org.hamcrest.Matchers.allOf;

import com.google.android.material.textfield.TextInputEditText;

import ru.iteco.fmhandroid.R;

public class AuthPage {

    public void enterLogin(String login) {
        onView(withId(R.id.login_text_input_layout));

        isAssignableFrom(TextInputEditText.class);
                //.perform(replaceText(login), closeSoftKeyboard());
    }

    public void enterPassword(String password) {
        onView(allOf(withId(R.id.password_text_input_layout)));
                isAssignableFrom(TextInputEditText.class);
                //.perform(replaceText(password), closeSoftKeyboard());
    }

    public void clickSignInButton() {
        onView(withId(R.id.enter_button));
        //isAssignableFrom(TextInputEditText.class);
                //.perform(click());
    }

    public void loginAs(String login, String password) {
        enterLogin(login);
        enterPassword(password);
        clickSignInButton();
    }
}
