package com.busbycreations.usafpfacalc;

import android.view.View;
import android.widget.AdapterView;

/**
 * Created by mobusby on 9/18/13.
 */
public class AgeSpinnerListener implements AdapterView.OnItemSelectedListener {

    public MainActivity mainActivity;

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//        parent.getItemAtPosition(pos);

        // for now, this is hard coded from spinner values...
        switch (pos) {
            case 0:
                mainActivity.setAge(20);
                break;
            case 1:
                mainActivity.setAge(30);
                break;
            case 2:
                mainActivity.setAge(40);
                break;
            case 3:
                mainActivity.setAge(50);
                break;
            case 4:
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
