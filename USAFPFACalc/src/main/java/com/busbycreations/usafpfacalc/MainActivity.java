package com.busbycreations.usafpfacalc;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {

    public static final String PREFS_NAME = "com.busbycreations.usafpfacalc.prefs";

    private ScoreCalculator scoreCalculator;

    private Spinner ageSpinner, genderSpinner, altitudeSpinner;
    private EditText waistSizeEditText, pushupsEditText, situpsEditText, runMinutesEditText, runSecondsEditText;
    private TextView scoreTextView;

    private ImageView waistImageView, pushupsImageView, situpsImageView, runImageView, scoreImageView;

    private GenderSpinnerListener genderSpinnerListener;
    private AgeSpinnerListener ageSpinnerListener;
    private AltitudeSpinnerListener altitudeSpinnerListener;
    private WaistSizeEditTextWatcher waistSizeEditTextWatcher;
    private PushupsEditTextWatcher pushupsEditTextWatcher;
    private SitupsEditTextWatcher situpsEditTextWatcher;
    private RunEditTextWatcher runEditTextWatcher;

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
        syncInputs();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor settingsEditor = settings.edit();

        settingsEditor.putInt("gender", genderSpinner.getSelectedItemPosition());
        settingsEditor.putInt("age", ageSpinner.getSelectedItemPosition());
        settingsEditor.putInt("altitude", altitudeSpinner.getSelectedItemPosition());

        settingsEditor.putFloat("waist", waistSizeEditText.length() > 0 ? Float.parseFloat(waistSizeEditText.getText().toString()) : 0);
        settingsEditor.putInt("pushups", pushupsEditText.length() > 0 ? Integer.parseInt(pushupsEditText.getText().toString()) : 0);
        settingsEditor.putInt("situps", situpsEditText.length() > 0 ? Integer.parseInt(situpsEditText.getText().toString()) : 0);
        settingsEditor.putInt("runminutes", runMinutesEditText.length() > 0 ? Integer.parseInt(runMinutesEditText.getText().toString()) : 0 );
        settingsEditor.putInt("runseconds", runSecondsEditText.length() > 0 ? Integer.parseInt(runSecondsEditText.getText().toString()) : 0 );

        settingsEditor.commit();
    }

    private void createInputs() {
        genderSpinner = (Spinner) findViewById(R.id.GenderSpinner);
        ageSpinner = (Spinner) findViewById(R.id.AgeSpinner);
        altitudeSpinner = (Spinner) findViewById(R.id.AltitudeSpinner);
        waistSizeEditText = (EditText) findViewById(R.id.WaistSizeTextInput);
        pushupsEditText = (EditText) findViewById(R.id.PushupsTextInput);
        situpsEditText = (EditText) findViewById(R.id.SitupsTextInput);
        runMinutesEditText = (EditText) findViewById(R.id.RunMinutesTextInput);
        runSecondsEditText = (EditText) findViewById(R.id.RunSecondsTextInput);
        scoreTextView = (TextView) findViewById(R.id.ScoreDisplayText);
    }

    private void createImageViews() {
        waistImageView = (ImageView) findViewById(R.id.waistSizeImageView);
        pushupsImageView = (ImageView) findViewById(R.id.pushupsImageView);
        situpsImageView = (ImageView) findViewById(R.id.situpsImageView);
        runImageView = (ImageView) findViewById(R.id.runTimeImageView);
        scoreImageView = (ImageView) findViewById(R.id.scoreImageView);
    }

    private void createListeners() {
        genderSpinnerListener = new GenderSpinnerListener();
        genderSpinnerListener.mainActivity = this;
        ageSpinnerListener = new AgeSpinnerListener();
        ageSpinnerListener.mainActivity = this;
        altitudeSpinnerListener = new AltitudeSpinnerListener();
        altitudeSpinnerListener.mainActivity = this;
        waistSizeEditTextWatcher = new WaistSizeEditTextWatcher();
        waistSizeEditTextWatcher.mainActivity = this;
        pushupsEditTextWatcher = new PushupsEditTextWatcher();
        pushupsEditTextWatcher.mainActivity = this;
        situpsEditTextWatcher = new SitupsEditTextWatcher();
        situpsEditTextWatcher.mainActivity = this;
        runEditTextWatcher = new RunEditTextWatcher();
        runEditTextWatcher.mainActivity = this;
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
        waistSizeEditText.addTextChangedListener(waistSizeEditTextWatcher);
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
        waistSizeEditText.setText(Float.toString(settings.getFloat("waist", 30)));
        pushupsEditText.setText(Integer.toString(settings.getInt("pushups", 0)));
        situpsEditText.setText(Integer.toString(settings.getInt("situps", 0)));
        runMinutesEditText.setText(Integer.toString(settings.getInt("runminutes", 10)));
        int sec = settings.getInt("runseconds", 30);
        String secs = Integer.toString(sec);
        runSecondsEditText.setText((sec < 10) ? "0" + secs : secs);

        // call these last, because it updates all the images, etc.
    }

    private void syncInputs() {
//        scoreCalculator.setGender(genderSpinner.getSelectedItemPosition());
//        scoreCalculator.setAge(ageSpinner.getSelectedItemPosition());
//        scoreCalculator.setAltitude(altitudeSpinner.getSelectedItemPosition());
//        scoreCalculator.setWaist(Float.parseFloat(waistSizeEditText.getText().toString()));
//        scoreCalculator.setPushups(Integer.parseInt(pushupsEditText.getText().toString()));
//        scoreCalculator.setSitups(Integer.parseInt(situpsEditText.getText().toString()));
//        scoreCalculator.setRun(Integer.parseInt(runMinutesEditText.getText().toString()),
//                Integer.parseInt(runSecondsEditText.getText().toString()));
    }

    private void displayScore(double score) {
        if (score > 99.999) scoreTextView.setTextColor(Color.BLUE);
        else if (score > 89.999) scoreTextView.setTextColor(Color.GREEN);
        else if (score > 74.999) scoreTextView.setTextColor(0xffffa500); // ORANGE
        else scoreTextView.setTextColor(Color.RED);
        scoreTextView.setText(String.format("%1$.1f", score));
        displayScoreRepresentation(score / 100.0, scoreImageView);
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

    public void setWaistSize(double waistSize) {
        displayScoreRepresentation(scoreCalculator.setWaist(waistSize), waistImageView);
        displayScore(scoreCalculator.getScore());
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
        displayScoreRepresentation(scoreCalculator.getWaistScore(), waistImageView);
        displayScoreRepresentation(scoreCalculator.getPushupsScore(), pushupsImageView);
        displayScoreRepresentation(scoreCalculator.getSitupsScore(), situpsImageView);
        displayScoreRepresentation(scoreCalculator.getRunScore(), runImageView);
//        displayScoreRepresentation(scoreCalculator.getScore(), scoreImageView);
    }
}
