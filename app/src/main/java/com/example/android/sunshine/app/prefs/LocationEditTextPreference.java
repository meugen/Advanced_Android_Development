package com.example.android.sunshine.app.prefs;

import android.content.Context;
import android.content.res.TypedArray;
import android.preference.EditTextPreference;
import android.util.AttributeSet;
import android.util.Log;

import com.example.android.sunshine.app.R;

/**
 * @author meugen
 */

public class LocationEditTextPreference extends EditTextPreference {

    private static final String TAG = LocationEditTextPreference.class.getSimpleName();

    private static final int DEFAULT_MIN_LENGTH = 2;

    private int minLength;

    public LocationEditTextPreference(final Context context, final AttributeSet attrs) {
        super(context, attrs);

        TypedArray array = null;
        try {
            array = context.getTheme().obtainStyledAttributes(
                    attrs, R.styleable.LocationEditTextPreference, 0, 0);
            minLength = array.getInt(R.styleable.LocationEditTextPreference_minLength,
                    DEFAULT_MIN_LENGTH);
            Log.d(TAG, "Min length: " + minLength);
        } finally {
            if (array != null) {
                array.recycle();
            }
        }

    }

    public LocationEditTextPreference(final Context context) {
        super(context);
    }
}
