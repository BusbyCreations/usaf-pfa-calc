package com.busbycreations.usafpfacalc;

/** Copyright (c) 2013 Mark O. Busby
 *  Licensed under the MIT license (see LICENSE.txt)
 */

public class ScoreCalculator {
    private int gender, age, altitude, situps, pushups, run;
    private int ageIndex;
    private double waist;

    public ScoreCalculator() {
        this(ScoreChart.MALE, 25,0, 30, 50, 50, 660);
    }

    public ScoreCalculator(int gender, int age, int altitude, double waist, int pushups, int situps, int run) {
        this.gender = gender;
        this.age = age;
        this.altitude = altitude;
        this.waist = waist;
        this.pushups = pushups;
        this.situps = situps;
        this.run = run;

        setAgeIndex();
    }

    public int convertRunTime(int minutes, int seconds) {
        return (int) (60. * (double) minutes + (double) seconds);
    }

    public double setGender(int gender) {
        this.gender = gender;
        return getScore();
    }

    public double setAge(int age) {
        this.age = age;
        setAgeIndex();
        return getScore();
    }

    public double setAltitude(int altitude) {
        this.altitude = altitude;
        return p_getRunScore() / (double) ScoreChart.MAX_RUN_SCORE;
    }

    // returns the percentage of perfect score received (non-zero is passing, strive for > 90%)
    public double setWaist(double waist) {
        this.waist = waist;
        return getWaistScore();
    }

    public double setPushups(int pushups) {
        this.pushups = pushups;
        return getPushupsScore();
    }

    public double setSitups(int situps) {
        this.situps = situps;
        return getSitupsScore();
    }

    public double setRun(int run) {
        this.run = run;
        return getRunScore();
    }

    public double setRun(int minutes, int seconds) {
        return setRun(convertRunTime(minutes, seconds));
    }

    // returns the actual score -- 100 is max, 75 is passing, strive for >= 90
    public double getScore() {
        double score = 0;

        score += p_getWaistScore();
        score += p_getPushupsScore();
        score += p_getSitupsScore();
        score += p_getRunScore();

        return score;
    }

    private void setAgeIndex() {
        if (age < 30) ageIndex = ScoreChart.TWENTY;
        else if (age < 40) ageIndex = ScoreChart.THIRTY;
        else if (age < 50) ageIndex = ScoreChart.FOURTY;
        else if (age < 60) ageIndex = ScoreChart.FIFTY;
        else ageIndex = ScoreChart.SIXTY;
    }

    private double p_getWaistScore() {
        if (waist < ScoreChart.WAIST_SCORES[0][2]) return 20;
        for (int i = 0; i < ScoreChart.WAIST_SCORES.length; i++){
            if (waist == ScoreChart.WAIST_SCORES[i][2]) {
                return ScoreChart.WAIST_SCORES[i][gender];
            }
        }

        // We have ourselves a fatty, or an invalid waist size... either way...
        return 0;
    }

    private double p_getPushupsScore() {
        if (pushups > ScoreChart.MAX_PUSHUPS) return ScoreChart.MAX_PUSHUPS_SCORE;
        return ScoreChart.PUSHUPS_SITUPS_SCORES[ageIndex][gender][pushups][ScoreChart.PUSHUPS];
    }

    private double p_getSitupsScore() {
        if (situps > ScoreChart.MAX_SITUPS) return ScoreChart.MAX_SITUPS_SCORE;
        return ScoreChart.PUSHUPS_SITUPS_SCORES[ageIndex][gender][situps][ScoreChart.SITUPS];
    }

    private int getAltitudeCorrectedTime() {
        int altIndex = 1;

        if (altitude < ScoreChart.ALTITUDES[0]) return run;
        else if (altitude < ScoreChart.ALTITUDES[1]) altIndex = 1;
        else if (altitude < ScoreChart.ALTITUDES[2]) altIndex = 2;
        else if (altitude < ScoreChart.ALTITUDES[3]) altIndex = 3;
        else altIndex = 4;

        for (int i = 0; i < ScoreChart.ALTITUDE_CORRECTIONS.length; i++) {
            if (run < ScoreChart.ALTITUDE_CORRECTIONS[i][0]) return run - ScoreChart.ALTITUDE_CORRECTIONS[i][altIndex];
        }

        // This is an impossible case... just return the maximum correction for the given altitude
        return run - ScoreChart.ALTITUDE_CORRECTIONS[ScoreChart.ALTITUDE_CORRECTIONS.length - 1][altIndex];
    }

    private double p_getRunScore() {
        int run = getAltitudeCorrectedTime();

        for (int i = 0; i < ScoreChart.RUN_SCORES[gender].length; i++)
            if (run < ScoreChart.RUN_SCORES[gender][i][5]) return ScoreChart.RUN_SCORES[gender][i][ageIndex];

        // we have ourselves a slow-poke, or an invalid run time... either way...
        return 0;
    }

    public double getWaistScore() {
        return p_getWaistScore() / (double) ScoreChart.MAX_WAIST_SCORE;
    }

    public double getPushupsScore() {
        return p_getPushupsScore() / (double) ScoreChart.MAX_PUSHUPS_SCORE;
    }

    public double getSitupsScore() {
        return p_getSitupsScore() / (double) ScoreChart.MAX_SITUPS_SCORE;
    }

    public double getRunScore() {
        return p_getRunScore() / (double) ScoreChart.MAX_RUN_SCORE;
    }
}
