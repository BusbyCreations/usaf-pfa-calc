package com.busbycreations.usafpfacalc;

/** Copyright (c) 2013 Mark O. Busby
 *  Licensed under the MIT license (see LICENSE.txt)
 */

public class ScoreCalculator {
    private int gender, age, altitude, situps, pushups, run;
    private int ageIndex;

    public ScoreCalculator() {
        this(ScoreChart.MALE, 35, 0, 50, 50, 660);
    }

    public ScoreCalculator(int gender, int age, int altitude, int pushups, int situps, int run) {
        this.gender = gender;
        this.age = age;
        this.altitude = altitude;
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

        score += p_getPushupsScore();
        score += p_getSitupsScore();
        score += p_getRunScore();

        return score;
    }

    private void setAgeIndex() {
        if (age < 25) ageIndex = ScoreChart.TWENTY;
        else if (age < 30) ageIndex = ScoreChart.TWENTYF;
        else if (age < 35) ageIndex = ScoreChart.THIRTY;
        else if (age < 40) ageIndex = ScoreChart.THIRTYF;
        else if (age < 45) ageIndex = ScoreChart.FOURTY;
        else if (age < 50) ageIndex = ScoreChart.FOURTYF;
        else if (age < 55) ageIndex = ScoreChart.FIFTY;
        else if (age < 60) ageIndex = ScoreChart.FIFTYF;
        else ageIndex = ScoreChart.SIXTY;
    }

    private double p_getPushupsScore() {
        if (pushups > ScoreChart.MAX_PUSHUPS) return ScoreChart.MAX_PUSHUPS_SCORE;
        return ScoreChart.PUSH[pushups][gender][ageIndex];
    }

    private double p_getSitupsScore() {
        if (situps > ScoreChart.MAX_SITUPS) return ScoreChart.MAX_SITUPS_SCORE;
        return ScoreChart.SIT[situps][gender][ageIndex];
    }

    private int getAltitudeCorrectedTime() {
        int altIndex = 1;

        if (altitude < ScoreChart.ALTITUDES[0]) return run;
        else if (altitude < ScoreChart.ALTITUDES[1]) altIndex = 1;
        else if (altitude < ScoreChart.ALTITUDES[2]) altIndex = 2;
        else if (altitude < ScoreChart.ALTITUDES[3]) altIndex = 3;
        else altIndex = 4;

        // compare run time to correction chart entries, row by row, and return the corrected run time
        for (int i = 0; i < ScoreChart.ALTITUDE_CORRECTIONS.length; i++) {
            if (run < ScoreChart.ALTITUDE_CORRECTIONS[i][0]) return run - ScoreChart.ALTITUDE_CORRECTIONS[i][altIndex];
        }

        // This is an impossible case... just return the maximum correction for the given altitude
        return run - ScoreChart.ALTITUDE_CORRECTIONS[ScoreChart.ALTITUDE_CORRECTIONS.length - 1][altIndex];
    }

    private double p_getRunScore() {
        int runTime = getAltitudeCorrectedTime();

        // Correct for runtime-band special cases where band break on chart is at 17:34 instead of 17:33
        if (runTime == 1054 && ((gender == ScoreChart.MALE && (ageIndex == ScoreChart.FIFTY || ageIndex == ScoreChart.SIXTY))
                || (gender == ScoreChart.FEMALE && (ageIndex == ScoreChart.TWENTY || ageIndex == ScoreChart.THIRTY || ageIndex == ScoreChart.SIXTY))))
            runTime -= 1;

        int runTimeBand = 0;
        if      (runTime < 553) runTimeBand = 0;
        else if (runTime < 563) runTimeBand = 1;
        else if (runTime < 575) runTimeBand = 2;
        else if (runTime < 586) runTimeBand = 3;
        else if (runTime < 599) runTimeBand = 4;
        else if (runTime < 611) runTimeBand = 5;
        else if (runTime < 624) runTimeBand = 6;
        else if (runTime < 638) runTimeBand = 7;
        else if (runTime < 652) runTimeBand = 8;
        else if (runTime < 667) runTimeBand = 9;
        else if (runTime < 683) runTimeBand = 10;
        else if (runTime < 699) runTimeBand = 11;
        else if (runTime < 717) runTimeBand = 12;
        else if (runTime < 735) runTimeBand = 13;
        else if (runTime < 754) runTimeBand = 14;
        else if (runTime < 774) runTimeBand = 15;
        else if (runTime < 795) runTimeBand = 16;
        else if (runTime < 817) runTimeBand = 17;
        else if (runTime < 841) runTimeBand = 18;
        else if (runTime < 866) runTimeBand = 19;
        else if (runTime < 893) runTimeBand = 20;
        else if (runTime < 921) runTimeBand = 21;
        else if (runTime < 951) runTimeBand = 22;
        else if (runTime < 983) runTimeBand = 23;
        else if (runTime < 1018) runTimeBand = 24;
        else if (runTime < 1054) runTimeBand = 25;
        else if (runTime < 1095) runTimeBand = 26;
        else if (runTime < 1137) runTimeBand = 27;
        else if (runTime < 1184) runTimeBand = 28;
        else if (runTime < 1234) runTimeBand = 29;
        else if (runTime < 1289) runTimeBand = 30;
        else if (runTime < 1349) runTimeBand = 31;
        else if (runTime < 1415) runTimeBand = 32;
        else if (runTime < 1487) runTimeBand = 33;
        else if (runTime < 1567) runTimeBand = 34;
        else if (runTime < 1648) runTimeBand = 35;
        else runTimeBand = 36;

        return ScoreChart.RUN[runTimeBand][gender][ageIndex];
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
