package com.example.android.sunshine.app.prefs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.android.sunshine.app.R;

/**
 * @author meugen
 */

public class LocationEditTextPreference extends EditTextPreference implements TextWatcher {

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

    @Override
    protected void showDialog(final Bundle state) {
        super.showDialog(state);
        getEditText().addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(
            final CharSequence s, final int start, final int count, final int after) {}

    @Override
    public void onTextChanged(
            final CharSequence s, final int start, final int before, final int count) {}

    @Override
    public void afterTextChanged(final Editable s) {
        final Dialog dialog = getDialog();
        if (dialog instanceof AlertDialog) {
            final AlertDialog alertDialog = (AlertDialog) dialog;
            final Button button = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
            button.setVisibility(s.length() >= minLength ? View.VISIBLE : View.INVISIBLE);
        }
    }
}
