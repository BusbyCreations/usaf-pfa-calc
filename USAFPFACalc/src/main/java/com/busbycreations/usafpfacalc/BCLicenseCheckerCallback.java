package com.busbycreations.usafpfacalc;

import android.os.Handler;

import com.google.android.vending.licensing.LicenseCheckerCallback;
import com.google.android.vending.licensing.Policy;

/** Copyright (c) 2013 Mark O. Busby
 *  Licensed under the MIT license (see LICENSE.txt)
 *
 * BCLicenseCheckerCallback is part of BCLicense - an implementation of Google Play Licensing.
 * It is intended to be customized directly to fit the needs of the application.
 */

public class BCLicenseCheckerCallback implements LicenseCheckerCallback {

    private MainActivity mainActivity;
    private BCLicense bcLicense;
    private Handler licensingHandler;

    protected BCLicenseCheckerCallback(MainActivity mainActivity, BCLicense bcLicense, Handler licensingHandler) {
        super();
        this.mainActivity = mainActivity;
        this.bcLicense = bcLicense;
        this.licensingHandler = licensingHandler;
    }

    // Customize these functions -- they are called when a response from Google Play is received.
    public void allow(int policyResponse) {
        // A valid license exists.  It's a free app, after all.
    }

    public void dontAllow(final int policyResponse) {
        // No valid license exists
        licensingHandler.post(new Runnable() {
            @Override
            public void run() {
                if (policyResponse == Policy.RETRY) {
                    // Try again.
                    bcLicense.checkLicensing();
                } else {
                    // TODO: create a dialog with some information about the proper way to get this app
                }
            }
        });
    }

    public void applicationError(int errorCode) {
        // Developer error

        // TODO: display a dialog, I guess... Again, I really don't care.
        // Apparently, use licensingHandler to do it...
    }
}
