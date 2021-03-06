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

        switch (pos) {
            case 0:
                mainActivity.setGender(ScoreChart.MALE);
                break;
            case 1:
                mainActivity.setGender(ScoreChart.FEMALE);
                break;
            default:
                mainActivity.setGender(ScoreChart.MALE);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO: set male
    }
}
