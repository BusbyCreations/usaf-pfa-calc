package com.busbycreations.usafpfacalc;

import android.text.Editable;
import android.text.TextWatcher;

/**
 * Created by mobusby on 9/20/13.
 */
public class WaistSizeEditTextWatcher implements TextWatcher {

    MainActivity mainActivity;

    public WaistSizeEditTextWatcher(MainActivity mainActivity) {
        super();
        this.mainActivity = mainActivity;
    }

    public void onTextChanged(CharSequence sequence, int start, int before, int count) {

    }

    public void afterTextChanged(Editable editable) {
        if (editable.length() != 0)
            mainActivity.setWaistSize(Double.parseDouble(editable.toString()));

        // TODO: don't accept stupid inputs
    }

    public void beforeTextChanged(CharSequence sequence, int start, int count, int after) {

    }
}
