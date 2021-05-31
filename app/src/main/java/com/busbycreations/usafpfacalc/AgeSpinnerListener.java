package com.busbycreations.usafpfacalc;

import android.view.View;
import android.widget.AdapterView;

/** Copyright (c) 2013 Mark O. Busby
 *  Licensed under the MIT license (see LICENSE.txt)
 */

public class AgeSpinnerListener implements AdapterView.OnItemSelectedListener {

    public MainActivity mainActivity;

    public AgeSpinnerListener(MainActivity mainActivity) {
        super();
        this.mainActivity = mainActivity;
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//        parent.getItemAtPosition(pos);

        // for now, this is hard coded from spinner values...
        switch (pos) {
            case 0:
                mainActivity.setAge(20);
                break;
            case 1:
                mainActivity.setAge(25);
                break;
            case 2:
                mainActivity.setAge(30);
                break;
            case 3:
                mainActivity.setAge(35);
                break;
            case 4:
                mainActivity.setAge(40);
                break;
            case 5:
                mainActivity.setAge(45);
                break;
            case 6:
                mainActivity.setAge(50);
                break;
            case 7:
                mainActivity.setAge(55);
                break;
            case 8:
                mainActivity.setAge(60);
                break;
            default: // we should never get here
                mainActivity.setAge(20);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO: something...
    }
}
