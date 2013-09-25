package com.busbycreations.usafpfacalc;

import android.text.Editable;
import android.text.TextWatcher;

/** Copyright (c) 2013 Mark O. Busby
 *  Licensed under the MIT license (see LICENSE.txt)
 */

public class PushupsEditTextWatcher implements TextWatcher {

    MainActivity mainActivity;

    public PushupsEditTextWatcher(MainActivity mainActivity) {
        super();
        this.mainActivity = mainActivity;
    }

    public void onTextChanged(CharSequence sequence, int start, int before, int count) {

    }

    public void afterTextChanged(Editable editable) {
        if (editable.length() != 0)
            mainActivity.setPushups(Integer.parseInt(editable.toString()));

        // TODO: don't accept stupid inputs
    }

    public void beforeTextChanged(CharSequence sequence, int start, int count, int after) {

    }
}