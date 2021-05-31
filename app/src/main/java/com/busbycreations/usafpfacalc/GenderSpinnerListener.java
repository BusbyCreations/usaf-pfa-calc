package com.busbycreations.usafpfacalc;

import android.view.View;
import android.widget.AdapterView;

/** Copyright (c) 2013 Mark O. Busby
 *  Licensed under the MIT license (see LICENSE.txt)
 */

public class GenderSpinnerListener implements AdapterView.OnItemSelectedListener {

    public MainActivity mainActivity;

    public GenderSpinnerListener(MainActivity mainActivity) {
        super();
        this.mainActivity = mainActivity;
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//        parent.getItemAtPosition(pos);

        if (pos == 1) mainActivity.setGender(ScoreChart.FEMALE);
        else mainActivity.setGender(ScoreChart.MALE);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO: set male
    }
}
