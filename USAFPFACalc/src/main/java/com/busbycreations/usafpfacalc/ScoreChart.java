package com.busbycreations.usafpfacalc;

/** Copyright (c) 2013 Mark O. Busby
 *  Licensed under the MIT license (see LICENSE.txt)
 */

public class ScoreChart extends ScoreChartPrivate {
    // A container class, just holds charts

    // index values for the arrays
    public static final int MALE = 0;
    public static final int FEMALE = 1;

    public static final int TWENTY = 0;
    public static final int THIRTY = 1;
    public static final int FOURTY = 2;
    public static final int FIFTY = 3;
    public static final int SIXTY = 4;

    public static final int PUSHUPS = 0;
    public static final int SITUPS = 1;

    public static final int MAX_PUSHUPS = 67;
    public static final int MAX_SITUPS = MAX_PUSHUPS;
    public static final int MAX_PUSHUPS_SCORE = 10;
    public static final int MAX_SITUPS_SCORE = 10;

    public static final int MAX_WAIST_SCORE = 20;
    public static final int MAX_RUN_SCORE = 60;

    // access waist score with WAISTS[size_index][gender_index]
    // get size_index by comparing WAISTS[i][2] to your size ==> i = your index
    public static final double WAIST_SCORES[][] = WAISTS;

    // access pushups and situps scores: PUSHUPS_SITUPS[age_index][gender_index][count][PUSHUPS | SITUPS];
    public static final double PUSHUPS_SITUPS_SCORES[][][][] = {PS_TWENTY, PS_THIRTY, PS_FOURTY, PS_FIFTY, PS_SIXTY};

    // access run scores using RUN_SCORES[gender_index][time_index][age_index]
    public static final double RUN_SCORES[][][] = {RUN_MALE, RUN_FEMALE};
}
