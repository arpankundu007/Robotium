package com.warmach.robotium;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.robotium.solo.Solo;

import junit.framework.Assert;

/**
 * Created by WarMach on 16-Jun-16.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private Solo solo;
    public MainActivityTest() {
        super(MainActivity.class);
    }

    public void setUp() throws Exception {
        super.setUp();
        solo = new Solo(getInstrumentation(), getActivity());
    }


    @Override
    public void tearDown() throws Exception {
        try {
            solo.finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        solo.finishOpenedActivities();
        super.tearDown();
    }

    public void testInterface() throws Exception {
        solo.assertCurrentActivity("Check activity", MainActivity.class);
        EditText et = (EditText) solo.getView(R.id.editText);
        EditText et2 = (EditText) solo.getView(R.id.editText2);
        EditText et3 = (EditText) solo.getView(R.id.editText3);
        solo.enterText(et,"Test case Stuff");
        solo.enterText(et2, "password");
        solo.enterText(et3, "password");
        assertEquals(et2.getText().toString(),et3.getText().toString());
        solo.clickOnButton(0);
        solo.waitForActivity("SecondActivity");
        solo.assertCurrentActivity("Check activity", SecondActivity.class);
        solo.clickOnButton(0);
        solo.waitForActivity("ThirdActivity");
        solo.assertCurrentActivity("Check Activity", ThirdActivity.class);
        solo.enterText(0,"Third Activity Test");
        solo.clickOnButton(0);
        TextView tv3 = (TextView) solo.getView(R.id.textView_3a);
        assertEquals(tv3.getText().toString(), "Third Activity Test");
    }
}
