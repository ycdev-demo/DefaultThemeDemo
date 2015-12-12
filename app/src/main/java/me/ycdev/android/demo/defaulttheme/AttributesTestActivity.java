package me.ycdev.android.demo.defaulttheme;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;

public class AttributesTestActivity extends Activity {
    private static final String TAG = "AttributesTestActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attributes_test);

        testThemeAttributes();
        testStyleAttributes();
        testStyle2Attributes();
        resolveThemeAttributes();
    }

    private static void printTestAttributes(TypedArray array) {
        float disabledAlpha = array.getFloat(R.styleable.TestAttributesSet_android_disabledAlpha, 0);
        int textColorSecondary = array.getColor(R.styleable.TestAttributesSet_android_textColorSecondary, 0x77ff0000);
        float backgroundDim = array.getFloat(R.styleable.TestAttributesSet_android_backgroundDimAmount, 0);
        Log.i(TAG, "disabledAlpha: " + disabledAlpha
                + ", textColorSecondary: 0x" + Integer.toHexString(textColorSecondary)
                + ", backgroundDim: " + backgroundDim);

        String appTestLabel = array.getString(R.styleable.TestAttributesSet_app_test_label);
        int appTestColor = array.getColor(R.styleable.TestAttributesSet_app_test_color, 0x7700ff00);
        Log.i(TAG, "appTestLabel: " + appTestLabel
                + ", appTestColor: 0x" + Integer.toHexString(appTestColor));
    }

    private void testThemeAttributes() {
        Log.d(TAG, "------------ Obtain theme attributes -------------");
        TypedArray array = getTheme().obtainStyledAttributes(R.styleable.TestAttributesSet);
        try {
            printTestAttributes(array);
        } finally {
            array.recycle();
        }
    }

    private void testStyleAttributes() {
        Log.d(TAG, "------------ Obtain style attributes -------------");
        TypedArray array = getTheme().obtainStyledAttributes(R.style.AppWidget_TestStyle,
                R.styleable.TestAttributesSet);
        try {
            printTestAttributes(array);
        } finally {
            array.recycle();
        }
    }

    private void testStyle2Attributes() {
        Log.d(TAG, "------------ Obtain style2 attributes -------------");
        TypedArray array = getTheme().obtainStyledAttributes(R.style.AppWidget_TestStyle2,
                R.styleable.TestAttributesSet);
        try {
            printTestAttributes(array);
        } finally {
            array.recycle();
        }
    }

    private void resolveThemeAttributes() {
        Log.d(TAG, "------------ Resolve theme attributes -------------");
        TypedValue out = new TypedValue();
        if (getTheme().resolveAttribute(android.R.attr.backgroundDimAmount, out, true)) {
            Log.d(TAG, "android:backgroundDimAmount found: " + out.coerceToString());
        }
        if (getTheme().resolveAttribute(R.attr.app_test_label, out, true)) {
            Log.d(TAG, "app_test_label found: " + out.coerceToString());
        }
        if (getTheme().resolveAttribute(R.attr.app_test_color, out, true)) {
            Log.d(TAG, "app_test_color found: " + out.coerceToString());
        }
    }
}
