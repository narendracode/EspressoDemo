package com.hello.espresso;

import org.hamcrest.Matchers;
import android.test.ActivityInstrumentationTestCase2;
import android.support.test.InstrumentationRegistry;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;


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



public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    MainActivity mainActivity;
    TextView textView;
    Button button;
    EditText editText;

    public MainActivityTest(){
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        mainActivity = getActivity();
        textView = (TextView)mainActivity.findViewById(R.id.textView);
        button = (Button)mainActivity.findViewById(R.id.button);
        editText = (EditText)mainActivity.findViewById(R.id.editText);
    }

    public void testPreconditions() {
        assertNotNull(mainActivity);
        assertNotNull(textView);
        assertNotNull(button);
        assertNotNull(editText);
    }


    public void testChangeText_sameActivity() {
   // String text = "25";
        String text = "Hi, Good Morning";
    onView(withId(R.id.editText)).perform(typeText(text), closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click()) ;

        assertNotNull(R.id.textView);

        //String testResult = textView.getText().toString();
        //assertEquals(25, Integer.parseInt(testResult));
       // assertEquals(text, editText.getText().toString());
        assertTrue(text.equals(editText.getText().toString()));
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}

