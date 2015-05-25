package com.hello.espresso;

/**
 * Created by narendra on 25/5/15.
 */
import android.support.test.InstrumentationRegistry;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
public class LoginActivityTest extends ActivityInstrumentationTestCase2<LoginActivity> {
   LoginActivity loginActivity;
    EditText userNameEditText;
    EditText passwordEditText;
    Button loginButton;
    Button signupButton;
    TextView msgTextView;
    public static final String  INVALID_LOGIN_MESSAGE = "Username/Password incorrect, please try again." ;
    public static final String welcomeMsg = "Welcome to Main view.";
    public LoginActivityTest(){
        super(LoginActivity.class);

    }


    @Override
    protected void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        loginActivity = getActivity();
        userNameEditText = (EditText)loginActivity.findViewById(R.id.usernameEditText);
        passwordEditText = (EditText)loginActivity.findViewById(R.id.passwordEditText);
        loginButton = (Button)loginActivity.findViewById(R.id.loginButton);
        signupButton = (Button)loginActivity.findViewById(R.id.signupButton);
        msgTextView = (TextView)loginActivity.findViewById(R.id.msgTextView);
    }

    public void testPreconditions() {
        assertNotNull(loginActivity);
        assertNotNull(userNameEditText);
        assertNotNull(passwordEditText);
        assertNotNull(loginButton);
        assertNotNull(signupButton);
        assertNotNull(msgTextView);
    }

    public void testInvalidLogin() {
        String userName = "username";
        String password = "password";
        onView(withId(R.id.usernameEditText)).perform(typeText(userName), closeSoftKeyboard());
        onView(withId(R.id.passwordEditText)).perform(typeText(password), closeSoftKeyboard());
        onView(withId(R.id.loginButton)).perform(click());
        assertTrue(INVALID_LOGIN_MESSAGE.equals(msgTextView.getText().toString()));
    }

    /*public void testValidLogin(){
        String userName = "hellotech";
        String password = "hellotech";
        onView(withId(R.id.usernameEditText)).perform(typeText(userName), closeSoftKeyboard());
        onView(withId(R.id.passwordEditText)).perform(typeText(password),closeSoftKeyboard());
        onView(withId(R.id.loginButton)).perform(click());
        assertFalse(INVALID_LOGIN_MESSAGE.equals(msgTextView.getText().toString()));
    }
*/

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
