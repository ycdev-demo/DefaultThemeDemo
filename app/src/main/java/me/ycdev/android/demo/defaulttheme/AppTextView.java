package me.ycdev.android.demo.defaulttheme;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

public class AppTextView extends TextView {
    private static final String TAG = "AppTextView";

    public AppTextView(Context context) {
        super(context);
        testAttributes(context, null, 0, 0);
    }

    public AppTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        testAttributes(context, attrs, 0, 0);
    }

    public AppTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        testAttributes(context, attrs, defStyleAttr, 0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public AppTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        testAttributes(context, attrs, defStyleAttr, defStyleRes);
    }

    private void testAttributes(Context context, AttributeSet set, int defStyleAttr, int defStyleRes) {
        Log.d(TAG, "------------ Obtain AppTextView attributes -------------");
        TypedArray array = context.getTheme().obtainStyledAttributes(set,
                R.styleable.TestAttributesSet, defStyleAttr, defStyleRes);
        try {
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

            setText(appTestLabel);
            setTextColor(appTestColor);
        } finally {
            array.recycle();
        }
    }
}
