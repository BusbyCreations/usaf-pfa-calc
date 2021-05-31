package com.busbycreations.usafpfacalc;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/** Copyright (c) 2013 Mark O. Busby
 *  Licensed under the MIT license (see LICENSE.txt)
 */

public class FirstRunDialogFragment extends DialogFragment {

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstance) {
        View inflated = layoutInflater.inflate(R.layout.dialog_first_run, container, false);

        WebView wv = (WebView) inflated.findViewById(R.id.explanationWebView);
        wv.loadData(getString(R.string.first_run_dialog_explanation), "text/html", "utf-8");

        return inflated;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.setTitle(getString(R.string.first_run_dialog_title));
        return dialog;
    }
}
