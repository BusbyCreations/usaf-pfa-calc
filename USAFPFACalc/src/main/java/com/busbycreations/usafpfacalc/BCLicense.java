package com.busbycreations.usafpfacalc;

import com.google.android.vending.licensing.AESObfuscator;
import com.google.android.vending.licensing.LicenseChecker;
import com.google.android.vending.licensing.LicenseCheckerCallback;
import com.google.android.vending.licensing.ServerManagedPolicy;
import android.os.Handler;
import android.provider.Settings;

/**
 * Created by mobusby on 9/24/13.
 *
 * BCLicense - an implementation of Google Play Licensing.
 * It is intended to be customized directly to fit the needs of the application.
 */

public class BCLicense {

    // Customize these two variables -- they should be application specific
    private static final String BASE64_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhO99r3x4Q+Pf74ojr69x3390vjQuQ2Y3b+OoyZgN9XIu8U7nsbmqavFVVivO5xWHPI/yp//3aPwdYXDSoHKG+Q9almdHa8o5xsNgx+wGbd8j8wt0a81RN/04PULXoBxXbd1osCS5Y/C40xdok2o+ezXdjEIGS0gZqde44lU9UAbf8YLLrPerCM7JeyinDdOjLL5oagxPfoYNwLKW2M9XDv3ig2+QapMBQ6Yf2lbl+lkKtoUCcvehYeGGA/Alqfu85pVlu9DIhizAitU9NuWSOZXYLWgkYuu7F00zJPRXIQcG8AOfVgZVmriOa6wzBGxTDrO1j1XvSW+0d5WZ7hIYrwIDAQAB";
    private static final byte[] LICENSING_SALT = {85, 48, 110, -110, 44, 120, 59, -28, 37, 116, -107, 82, -38, 17, -59, -52, 109, 92, 104, 110};

    // Leave the rest of this code alone... Go customize BCLicenseCheckerCallback.

    private LicenseCheckerCallback licenseCheckerCallback;
    private LicenseChecker licenseChecker;
    private Handler licensingHandler;
    private MainActivity mainActivity;

    protected BCLicense(MainActivity mainActivity) {
        this.mainActivity = mainActivity;

        licensingHandler = new Handler();

        setupLicensing();
    }

    private void setupLicensing() {

        String deviceID = Settings.Secure.getString(mainActivity.getContentResolver(), Settings.Secure.ANDROID_ID);
        AESObfuscator obfuscator = new AESObfuscator(LICENSING_SALT, mainActivity.getPackageName(), deviceID);
        ServerManagedPolicy policy = new ServerManagedPolicy(mainActivity, obfuscator);

        licenseChecker = new LicenseChecker(mainActivity, policy, BASE64_PUBLIC_KEY);
        licenseCheckerCallback = new BCLicenseCheckerCallback(mainActivity, this, licensingHandler);
    }

    protected void checkLicensing() {
        licenseChecker.checkAccess(licenseCheckerCallback);
    }

    protected void onDestroy() {
        licenseChecker.onDestroy();
    }
}
