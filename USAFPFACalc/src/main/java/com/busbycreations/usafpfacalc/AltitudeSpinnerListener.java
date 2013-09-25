package com.busbycreations.usafpfacalc;

import android.view.View;
import android.widget.AdapterView;

/**
 * Created by mobusby on 9/18/13.
 */
public class AltitudeSpinnerListener implements AdapterView.OnItemSelectedListener {

    public MainActivity mainActivity;

    public AltitudeSpinnerListener(MainActivity mainActivity) {
        super();
        this.mainActivity = mainActivity;
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//        parent.getItemAtPosition(pos);

        // 0 = 0, 1 = 5251, 2 = 5501, 3 = 6001, 4 = 6601
        switch (pos) {
            case 0:
                mainActivity.setAltitude(0);
                break;
            case 1:
                mainActivity.setAltitude(5250);
                break;
            case 2:
                mainActivity.setAltitude(5500);
                break;
            case 3:
                mainActivity.setAltitude(6000);
                break;
            case 4:
                mainActivity.setAltitude(6600);
                break;
            default:
                mainActivity.setAltitude(0);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO: code something here?
    }
}