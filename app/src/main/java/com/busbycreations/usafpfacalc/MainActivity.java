package com.busbycreations.usafpfacalc;

import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ShareActionProvider;
import android.widget.Spinner;
import android.widget.TextView;

/** Copyright (c) 2013 Mark O. Busby
 *  Licensed under the MIT license (see LICENSE.txt)
 */

public class MainActivity extends Activity {

    public static final String PREFS_NAME = "com.busbycreations.usafpfacalc.prefs";

    // Licensing
//    private BCLicense bcLicense;

    private ScoreCalculator scoreCalculator;

    private Spinner ageSpinner, genderSpinner, altitudeSpinner;
//    private EditText waistSizeEditText;
    private EditText pushupsEditText, situpsEditText, runMinutesEditText, runSecondsEditText;
    private TextView scoreTextView;
//    private ImageView waistImageView;
    private ImageView pushupsImageView, situpsImageView, runImageView, scoreImageView;

    private GenderSpinnerListener genderSpinnerListener;
    private AgeSpinnerListener ageSpinnerListener;
    private AltitudeSpinnerListener altitudeSpinnerListener;
//    private WaistSizeEditTextWatcher waistSizeEditTextWatcher;
    private PushupsEditTextWatcher pushupsEditTextWatcher;
    private SitupsEditTextWatcher situpsEditTextWatcher;
    private RunEditTextWatcher runEditTextWatcher;

    private ShareActionProvider shareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createInputs();
        createImageViews();
        createListeners();

        scoreCalculator = new ScoreCalculator();

        createSpinnerAdapters();
        addListeners();
        initializeInputs();

        // Licensing
//        bcLicense = new BCLicense(this);
//        bcLicense.checkLicensing();

        // Get/Log the first run status, show the dialog as relevant
        if (getSharedPreferences(PREFS_NAME, 0).getBoolean("firstrun", true)) {
            getSharedPreferences(PREFS_NAME, 0).edit().putBoolean("firstrun", false).apply();
            showFirstRun();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        // share action
        MenuItem menuItem = menu.findItem(R.id.action_share);
        shareActionProvider = (ShareActionProvider) menuItem.getActionProvider();

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.action_share:
                Intent shareIntent = Intent.createChooser(createShareIntent(), null);
                startActivity(shareIntent);
                return true;
//            case R.id.action_donate:
//                return true;
            case R.id.action_about:
                showAbout();
                return true;
//            case R.id.action_settings:
//                showSettings();
//                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor settingsEditor = settings.edit();

        settingsEditor.putInt("gender", genderSpinner.getSelectedItemPosition());
        settingsEditor.putInt("age", ageSpinner.getSelectedItemPosition());
        settingsEditor.putInt("altitude", altitudeSpinner.getSelectedItemPosition());

//        settingsEditor.putFloat("waist", waistSizeEditText.length() > 0 ? Float.parseFloat(waistSizeEditText.getText().toString()) : 0);
        settingsEditor.putInt("pushups", pushupsEditText.length() > 0 ? Integer.parseInt(pushupsEditText.getText().toString()) : 0);
        settingsEditor.putInt("situps", situpsEditText.length() > 0 ? Integer.parseInt(situpsEditText.getText().toString()) : 0);
        settingsEditor.putInt("runminutes", runMinutesEditText.length() > 0 ? Integer.parseInt(runMinutesEditText.getText().toString()) : 0 );
        settingsEditor.putInt("runseconds", runSecondsEditText.length() > 0 ? Integer.parseInt(runSecondsEditText.getText().toString()) : 0 );

        settingsEditor.apply();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Licensing
//        bcLicense.onDestroy();
    }

    private Intent createShareIntent() {
        int minutes = Integer.parseInt(runMinutesEditText.length() > 0 ? runMinutesEditText.getText().toString() : "0");
        int seconds = Integer.parseInt(runSecondsEditText.length() > 0 ? runSecondsEditText.getText().toString() : "0");
        String runTime = String.format("%1$1d:%2$02d", minutes, seconds);

//        String percentFormat = "(%1$d%% max)%n";
//        String waistPercent = String.format(percentFormat, Math.round(scoreCalculator.getWaistScore() * 100.));
//        String pushupsPercent = String.format(percentFormat, Math.round(scoreCalculator.getPushupsScore() * 100.));
//        String situpsPercent = String.format(percentFormat, Math.round(scoreCalculator.getSitupsScore() * 100.));
//        String runPercent = String.format(percentFormat, Math.round(scoreCalculator.getRunScore() * 100.));

        String textToShare = "I just scored " + scoreTextView.getText().toString()
                + " on the Air Force Fitness Assessment: "
                + pushupsEditText.getText().toString() + " pushups, "
                + situpsEditText.getText().toString() + " situps, and "
                + runTime + " run time.";

        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT, textToShare);
        shareIntent.setType("text/plain");
        return shareIntent;
    }

    private void setShareIntent(Intent shareIntent) {
        if (shareActionProvider != null) {
            shareActionProvider.setShareIntent(shareIntent);
        }
    }

    private void createInputs() {
        genderSpinner = (Spinner) findViewById(R.id.GenderSpinner);
        ageSpinner = (Spinner) findViewById(R.id.AgeSpinner);
        altitudeSpinner = (Spinner) findViewById(R.id.AltitudeSpinner);
//        waistSizeEditText = (EditText) findViewById(R.id.WaistSizeTextInput);
        pushupsEditText = (EditText) findViewById(R.id.PushupsTextInput);
        situpsEditText = (EditText) findViewById(R.id.SitupsTextInput);
        runMinutesEditText = (EditText) findViewById(R.id.RunMinutesTextInput);
        runSecondsEditText = (EditText) findViewById(R.id.RunSecondsTextInput);
        scoreTextView = (TextView) findViewById(R.id.ScoreDisplayText);
    }

    private void createImageViews() {
//        waistImageView = (ImageView) findViewById(R.id.waistSizeImageView);
        pushupsImageView = (ImageView) findViewById(R.id.pushupsImageView);
        situpsImageView = (ImageView) findViewById(R.id.situpsImageView);
        runImageView = (ImageView) findViewById(R.id.runTimeImageView);
        scoreImageView = (ImageView) findViewById(R.id.scoreImageView);
    }

    private void createListeners() {
        genderSpinnerListener = new GenderSpinnerListener(this);
        ageSpinnerListener = new AgeSpinnerListener(this);
        altitudeSpinnerListener = new AltitudeSpinnerListener(this);
//        waistSizeEditTextWatcher = new WaistSizeEditTextWatcher(this);
        pushupsEditTextWatcher = new PushupsEditTextWatcher(this);
        situpsEditTextWatcher = new SitupsEditTextWatcher(this);
        runEditTextWatcher = new RunEditTextWatcher(this);
    }

    private void createSpinnerAdapters() {
        ArrayAdapter<CharSequence> genderSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.Genders, android.R.layout.simple_spinner_item);
        genderSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(genderSpinnerAdapter);

        ArrayAdapter<CharSequence> ageSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.Ages, android.R.layout.simple_spinner_item);
        ageSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ageSpinner.setAdapter(ageSpinnerAdapter);

        ArrayAdapter<CharSequence> altitudeSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.Altitudes, android.R.layout.simple_spinner_item);
        altitudeSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        altitudeSpinner.setAdapter(altitudeSpinnerAdapter);
    }

    private void addListeners() {
        genderSpinner.setOnItemSelectedListener(genderSpinnerListener);
        ageSpinner.setOnItemSelectedListener(ageSpinnerListener);
        altitudeSpinner.setOnItemSelectedListener(altitudeSpinnerListener);
        //waistSizeEditText.addTextChangedListener(waistSizeEditTextWatcher);
        pushupsEditText.addTextChangedListener(pushupsEditTextWatcher);
        situpsEditText.addTextChangedListener(situpsEditTextWatcher);
        runMinutesEditText.addTextChangedListener(runEditTextWatcher);
        runSecondsEditText.addTextChangedListener(runEditTextWatcher);
    }

    private void initializeInputs() {
        // setup inputs with values from last session
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        genderSpinner.setSelection(settings.getInt("gender", 0), false);
        ageSpinner.setSelection(settings.getInt("age", 0), false);
        altitudeSpinner.setSelection(settings.getInt("altitude", 0), false);
        //waistSizeEditText.setText(Float.toString(settings.getFloat("waist", 30)));
        pushupsEditText.setText(Integer.toString(settings.getInt("pushups", 0)));
        situpsEditText.setText(Integer.toString(settings.getInt("situps", 0)));
        runMinutesEditText.setText(Integer.toString(settings.getInt("runminutes", 10)));
        int sec = settings.getInt("runseconds", 30);
        String secs = Integer.toString(sec);
        runSecondsEditText.setText((sec < 10) ? "0" + secs : secs);

        // call these last, because it updates all the images, etc.
    }

    private void displayScore(double score) {
        if (score > 99.999) scoreTextView.setTextColor(Color.BLUE);
        else if (score > 89.999) scoreTextView.setTextColor(Color.GREEN);
        else if (score > 74.999) scoreTextView.setTextColor(0xffffa500); // ORANGE
        else scoreTextView.setTextColor(Color.RED);
        scoreTextView.setText(String.format("%1$.1f", score));
        displayScoreRepresentation(score / 100.0, scoreImageView);
//        setShareIntent(createShareIntent());
    }

    // Methods for the listeners to use:
    public void setGender(int gender) {
        displayScore(scoreCalculator.setGender(gender));
        updateAllScoreRepresentations();
    }

    public void setAge(int age) {
        displayScore(scoreCalculator.setAge(age));
        updateAllScoreRepresentations();
    }

    public void setAltitude(int altitude) {
        scoreCalculator.setAltitude(altitude);
        displayScore(scoreCalculator.getScore());
        updateAllScoreRepresentations();
    }

    public void setPushups(int pushups) {
        displayScoreRepresentation(scoreCalculator.setPushups(pushups), pushupsImageView);
        displayScore(scoreCalculator.getScore());
    }

    public void setSitups(int situps) {
        displayScoreRepresentation(scoreCalculator.setSitups(situps), situpsImageView);
        displayScore(scoreCalculator.getScore());
    }

    public void setRunTime() {
        int minutes = (runMinutesEditText.length() > 0 ? Integer.parseInt(runMinutesEditText.getText().toString()) : 0);
        int seconds = (runSecondsEditText.length() > 0 ? Integer.parseInt(runSecondsEditText.getText().toString()) : 0);
        displayScoreRepresentation(scoreCalculator.setRun(minutes, seconds), runImageView);
        displayScore(scoreCalculator.getScore());
    }

    private void displayScoreRepresentation(double score, ImageView iv) {
        if (score > 0.9999) iv.setImageResource(R.drawable.ic_blue_light);
        else if (score > .8999) iv.setImageResource(R.drawable.ic_green_light);
        else if (score > 0) iv.setImageResource(R.drawable.ic_orange_light);
        else iv.setImageResource(R.drawable.ic_red_light);
    }

    private void updateAllScoreRepresentations() {
//        displayScoreRepresentation(scoreCalculator.getWaistScore(), waistImageView);
        displayScoreRepresentation(scoreCalculator.getPushupsScore(), pushupsImageView);
        displayScoreRepresentation(scoreCalculator.getSitupsScore(), situpsImageView);
        displayScoreRepresentation(scoreCalculator.getRunScore(), runImageView);
//        displayScoreRepresentation(scoreCalculator.getScore(), scoreImageView);
    }

    private void showAbout() {
        AboutDialogFragment aboutDialogFragment = new AboutDialogFragment();
        aboutDialogFragment.show(getFragmentManager(), "about_dialog");
    }

//    private void showSettings() {
//
//    }

    private void showFirstRun() {
        FirstRunDialogFragment firstRunDialogFragment = new FirstRunDialogFragment();
        FragmentManager fm = getFragmentManager();
        firstRunDialogFragment.show(fm, "first_run_dialog");
    }
}
