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

public class AboutDialogFragment extends DialogFragment {

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstance) {
        View inflated = layoutInflater.inflate(R.layout.dialog_about, container, false);

        WebView webView = (WebView) inflated.findViewById(R.id.aboutDialogWebView);
        webView.loadData(getString(R.string.about_dialog_text), "text/html", "utf-8");

        return inflated;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);

        // For some reason, when we try this, the WebView never gets populated.
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // So, instead, just set a Title and live with it.
        dialog.setTitle(getString(R.string.about_dialog_title));

        return dialog;
    }
}
