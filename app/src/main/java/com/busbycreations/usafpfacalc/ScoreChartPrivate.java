package com.busbycreations.usafpfacalc;

/** Copyright (c) 2021 Mark O. Busby
 *  Licensed under the MIT license (see LICENSE.txt)
 */

public class ScoreChartPrivate {

    // pushups, situps, and run tables
    public static final double PUSH[][][] = { // [number][GenderIndex][AgeIndex]
            /*       M20   M25   M30   M35   M40   M45   M50   M55   M60     F20   F25   F30   F35   F40   F45   F50   F55   F60*/
            /* 0*/ {{   0,    0,    0,    0,    0,    0,    0,    0,    0}, {   0,    0,    0,    0,    0,    0,    0,    0,    0}},
            /* 1*/ {{   0,    0,    0,    0,    0,    0,    0,    0,    0}, {   0,    0,    0,    0,    0,    0,    0,    0,    0}},
            /* 2*/ {{   0,    0,    0,    0,    0,    0,    0,    0,    0}, {   0,    0,    0,    0,    0,    0,    0,    0,    0}},
            /* 3*/ {{   0,    0,    0,    0,    0,    0,    0,    0,    0}, {   0,    0,    0,    0,    0,    0,    0,    0,    0}},
            /* 4*/ {{   0,    0,    0,    0,    0,    0,    0,    0,    0}, {   0,    0,    0,    0,    0,    0,    0,    0,  1.0}},
            /* 5*/ {{   0,    0,    0,    0,    0,    0,    0,    0,    0}, {   0,    0,    0,    0,    0,    0,    0,  1.0,  4.0}},
            /* 6*/ {{   0,    0,    0,    0,    0,    0,    0,    0,    0}, {   0,    0,    0,    0,    0,    0,  1.0,  4.0,  7.0}},
            /* 7*/ {{   0,    0,    0,    0,    0,    0,    0,    0,    0}, {   0,    0,    0,    0,    0,  1.0,  4.0,  7.0, 10.0}},
            /* 8*/ {{   0,    0,    0,    0,    0,    0,    0,    0,    0}, {   0,    0,    0,    0,  1.0,  4.0,  7.0, 10.0, 10.6}},
            /* 9*/ {{   0,    0,    0,    0,    0,    0,    0,    0,    0}, {   0,    0,    0,    0,  4.0,  7.0, 10.0, 11.0, 11.4}},
            /*10*/ {{   0,    0,    0,    0,    0,    0,    0,    0,    0}, {   0,    0,    0,  1.0,  7.0, 10.0, 11.0, 12.0, 12.0}},
            /*11*/ {{   0,    0,    0,    0,    0,    0,    0,    0,  1.0}, {   0,    0,  1.0,  4.0, 10.0, 11.0, 12.0, 13.0, 13.0}},
            /*12*/ {{   0,    0,    0,    0,    0,    0,  1.0,  1.0,  4.0}, {   0,    0,  4.0,  7.0, 11.0, 12.0, 13.0, 14.0, 14.0}},
            /*13*/ {{   0,    0,    0,    0,    0,    0,  4.0,  4.0,  7.0}, {   0,    0,  7.0, 10.0, 12.0, 13.0, 14.0, 15.0, 15.0}},
            /*14*/ {{   0,    0,    0,    0,    0,    0,  7.0,  7.0, 10.0}, {   0,  1.0, 10.0, 12.0, 13.0, 14.0, 15.0, 16.0, 16.0}},
            /*15*/ {{   0,    0,    0,    0,    0,  1.0, 10.0, 10.0, 10.6}, { 1.0,  4.0, 12.0, 13.0, 14.0, 15.0, 16.0, 16.2, 17.0}},
            /*16*/ {{   0,    0,    0,    0,    0,  4.0, 10.6, 11.6, 11.0}, { 4.0,  7.0, 13.0, 13.6, 15.0, 15.6, 16.2, 16.4, 17.6}},
            /*17*/ {{   0,    0,    0,    0,    0,  7.0, 11.0, 12.0, 11.6}, { 7.0, 10.0, 13.6, 14.0, 15.6, 16.0, 16.4, 16.6, 18.0}},
            /*18*/ {{   0,    0,    0,    0,  1.0, 10.0, 11.6, 12.6, 12.0}, {10.0, 10.6, 14.0, 15.0, 16.0, 16.2, 16.6, 16.8, 18.8}},
            /*19*/ {{   0,    0,    0,    0,  4.0, 10.6, 12.0, 13.0, 12.6}, {11.0, 11.0, 15.0, 15.2, 16.2, 16.4, 16.8, 17.0, 19.0}},
            /*20*/ {{   0,    0,    0,    0,  7.0, 11.0, 13.0, 13.6, 13.0}, {11.6, 11.6, 15.2, 15.6, 16.4, 16.6, 17.0, 17.2, 19.5}},
            /*21*/ {{   0,    0,    0,  1.0, 10.0, 11.6, 14.0, 14.0, 14.0}, {12.0, 12.0, 15.6, 15.8, 16.6, 16.8, 17.2, 17.6, 20.0}},
            /*22*/ {{   0,    0,    0,  4.0, 11.0, 12.0, 14.4, 14.6, 15.0}, {12.6, 12.6, 15.8, 16.0, 16.8, 17.0, 17.3, 18.0, 20.0}},
            /*23*/ {{   0,    0,    0,  7.0, 11.6, 12.6, 14.6, 15.0, 16.0}, {13.0, 13.0, 16.0, 16.4, 17.0, 17.1, 17.4, 18.6, 20.0}},
            /*24*/ {{   0,    0,  1.0, 10.0, 12.0, 13.0, 15.0, 15.6, 17.0}, {14.0, 14.0, 16.4, 16.6, 17.1, 17.2, 17.6, 19.0, 20.0}},
            /*25*/ {{   0,    0,  4.0, 10.6, 13.0, 14.0, 16.0, 16.0, 17.6}, {14.4, 14.4, 16.6, 17.0, 17.2, 17.6, 18.0, 19.2, 20.0}},
            /*26*/ {{   0,    0,  7.0, 11.0, 14.0, 14.4, 16.4, 16.2, 18.0}, {14.6, 14.6, 17.0, 17.2, 17.6, 17.8, 18.2, 19.4, 20.0}},
            /*27*/ {{   0,  1.0, 10.0, 12.0, 14.4, 14.6, 16.6, 16.6, 18.6}, {15.0, 15.0, 17.2, 17.3, 17.8, 18.0, 18.4, 19.7, 20.0}},
            /*28*/ {{   0,  4.0, 10.6, 13.0, 14.6, 15.0, 17.0, 16.8, 19.0}, {16.0, 16.0, 17.3, 17.4, 18.0, 18.2, 18.6, 20.0, 20.0}},
            /*29*/ {{   0,  7.0, 11.0, 13.4, 15.0, 16.0, 17.6, 17.0, 19.5}, {16.2, 16.2, 17.4, 17.6, 18.2, 18.4, 18.8, 20.0, 20.0}},
            /*30*/ {{ 1.0, 10.0, 12.0, 13.6, 16.0, 16.2, 18.0, 17.4, 20.0}, {16.4, 16.4, 17.6, 17.8, 18.4, 18.6, 19.0, 20.0, 20.0}},
            /*31*/ {{ 4.0, 10.6, 13.0, 14.0, 16.2, 16.6, 18.2, 17.6, 20.0}, {16.6, 16.6, 17.8, 17.9, 18.6, 18.8, 19.2, 20.0, 20.0}},
            /*32*/ {{ 7.0, 11.0, 13.4, 14.6, 16.6, 16.8, 18.3, 17.8, 20.0}, {16.8, 16.8, 17.9, 18.0, 18.8, 19.0, 19.4, 20.0, 20.0}},
            /*33*/ {{10.0, 11.6, 13.6, 15.0, 16.8, 17.0, 18.4, 18.0, 20.0}, {17.0, 17.0, 18.0, 18.1, 19.0, 19.2, 19.6, 20.0, 20.0}},
            /*34*/ {{10.6, 12.0, 14.0, 15.4, 17.0, 17.6, 18.5, 18.6, 20.0}, {17.2, 17.2, 18.1, 18.2, 19.2, 19.4, 19.8, 20.0, 20.0}},
            /*35*/ {{11.0, 12.6, 14.6, 15.6, 17.6, 18.0, 18.6, 19.0, 20.0}, {17.6, 17.6, 18.2, 18.4, 19.4, 19.6, 20.0, 20.0, 20.0}},
            /*36*/ {{11.6, 13.0, 15.0, 16.0, 18.0, 18.2, 18.7, 19.5, 20.0}, {17.8, 17.8, 18.4, 18.6, 19.6, 19.8, 20.0, 20.0, 20.0}},
            /*37*/ {{12.0, 13.6, 15.4, 16.6, 18.2, 18.4, 18.8, 20.0, 20.0}, {18.0, 18.0, 18.6, 18.7, 19.8, 20.0, 20.0, 20.0, 20.0}},
            /*38*/ {{12.6, 14.0, 15.6, 17.0, 18.4, 18.8, 18.9, 20.0, 20.0}, {18.2, 18.2, 18.7, 18.8, 20.0, 20.0, 20.0, 20.0, 20.0}},
            /*39*/ {{13.0, 14.4, 16.0, 17.2, 18.8, 19.0, 19.0, 20.0, 20.0}, {18.4, 18.4, 18.8, 19.0, 20.0, 20.0, 20.0, 20.0, 20.0}},
            /*40*/ {{13.6, 14.6, 16.6, 17.4, 19.0, 19.2, 19.2, 20.0, 20.0}, {18.6, 18.6, 19.0, 19.4, 20.0, 20.0, 20.0, 20.0, 20.0}},
            /*41*/ {{14.0, 15.0, 17.0, 17.6, 19.2, 19.4, 19.4, 20.0, 20.0}, {18.8, 18.8, 19.2, 19.7, 20.0, 20.0, 20.0, 20.0, 20.0}},
            /*42*/ {{14.4, 15.4, 17.2, 17.8, 19.4, 19.6, 19.6, 20.0, 20.0}, {19.0, 19.0, 19.4, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}},
            /*43*/ {{14.6, 15.6, 17.4, 18.0, 19.7, 19.8, 19.8, 20.0, 20.0}, {19.2, 19.2, 19.6, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}},
            /*44*/ {{15.0, 16.0, 17.6, 18.2, 20.0, 20.0, 20.0, 20.0, 20.0}, {19.4, 19.4, 19.8, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}},
            /*45*/ {{15.4, 16.2, 17.8, 18.4, 20.0, 20.0, 20.0, 20.0, 20.0}, {19.6, 19.6, 19.9, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}},
            /*46*/ {{15.6, 16.6, 18.0, 18.5, 20.0, 20.0, 20.0, 20.0, 20.0}, {19.8, 19.8, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}},
            /*47*/ {{16.0, 16.8, 18.2, 18.6, 20.0, 20.0, 20.0, 20.0, 20.0}, {20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}},
            /*48*/ {{16.2, 17.0, 18.4, 18.8, 20.0, 20.0, 20.0, 20.0, 20.0}, {20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}},
            /*49*/ {{16.6, 17.2, 18.5, 19.0, 20.0, 20.0, 20.0, 20.0, 20.0}, {20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}},
            /*50*/ {{16.8, 17.4, 18.6, 19.5, 20.0, 20.0, 20.0, 20.0, 20.0}, {20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}},
            /*51*/ {{17.0, 17.5, 18.8, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}, {20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}},
            /*52*/ {{17.2, 17.6, 19.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}, {20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}},
            /*53*/ {{17.4, 17.8, 19.2, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}, {20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}},
            /*54*/ {{17.5, 18.0, 19.4, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}, {20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}},
            /*55*/ {{17.6, 18.2, 19.6, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}, {20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}},
            /*56*/ {{17.8, 18.4, 19.8, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}, {20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}},
            /*57*/ {{18.0, 18.6, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}, {20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}},
            /*58*/ {{18.2, 18.8, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}, {20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}},
            /*59*/ {{18.4, 19.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}, {20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}},
            /*60*/ {{18.6, 19.4, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}, {20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}},
            /*61*/ {{18.8, 19.7, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}, {20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}},
            /*62*/ {{19.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}, {20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}},
            /*63*/ {{19.2, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}, {20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}},
            /*64*/ {{19.4, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}, {20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}},
            /*65*/ {{19.6, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}, {20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}},
            /*66*/ {{19.8, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}, {20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}},
            /*67*/ {{20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}, {20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}}
    };
    public static final double SIT[][][] = { // [number][GenderIndex][AgeIndex]
            /*       M20   M25   M30   M35   M40   M45   M50   M55   M60     F20   F25   F30   F35   F40   F45   F50   F55   F60*/
            /* 0*/ {{   0,    0,    0,    0,    0,    0,    0,    0,    0}, {   0,    0,    0,    0,    0,    0,    0,    0,    0}},
            /* 1*/ {{   0,    0,    0,    0,    0,    0,    0,    0,    0}, {   0,    0,    0,    0,    0,    0,    0,    0,    0}},
            /* 2*/ {{   0,    0,    0,    0,    0,    0,    0,    0,    0}, {   0,    0,    0,    0,    0,    0,    0,    0,    0}},
            /* 3*/ {{   0,    0,    0,    0,    0,    0,    0,    0,    0}, {   0,    0,    0,    0,    0,    0,    0,    0,    0}},
            /* 4*/ {{   0,    0,    0,    0,    0,    0,    0,    0,    0}, {   0,    0,    0,    0,    0,    0,    0,    0,    0}},
            /* 5*/ {{   0,    0,    0,    0,    0,    0,    0,    0,    0}, {   0,    0,    0,    0,    0,    0,    0,    0,    0}},
            /* 6*/ {{   0,    0,    0,    0,    0,    0,    0,    0,    0}, {   0,    0,    0,    0,    0,    0,    0,    0,    0}},
            /* 7*/ {{   0,    0,    0,    0,    0,    0,    0,    0,    0}, {   0,    0,    0,    0,    0,    0,    0,    0,    0}},
            /* 8*/ {{   0,    0,    0,    0,    0,    0,    0,    0,    0}, {   0,    0,    0,    0,    0,    0,    0,    0,  3.0}},
            /* 9*/ {{   0,    0,    0,    0,    0,    0,    0,    0,    0}, {   0,    0,    0,    0,    0,    0,    0,    0,  6.0}},
            /*10*/ {{   0,    0,    0,    0,    0,    0,    0,    0,    0}, {   0,    0,    0,    0,    0,    0,    0,    0,  9.0}},
            /*11*/ {{   0,    0,    0,    0,    0,    0,    0,    0,    0}, {   0,    0,    0,    0,    0,    0,    0,    0, 12.0}},
            /*12*/ {{   0,    0,    0,    0,    0,    0,    0,    0,    0}, {   0,    0,    0,    0,    0,    0,    0,  3.0, 13.0}},
            /*13*/ {{   0,    0,    0,    0,    0,    0,    0,    0,    0}, {   0,    0,    0,    0,    0,    0,    0,  6.0, 14.0}},
            /*14*/ {{   0,    0,    0,    0,    0,    0,    0,    0,    0}, {   0,    0,    0,    0,    0,    0,    0,  9.0, 14.6}},
            /*15*/ {{   0,    0,    0,    0,    0,    0,    0,    0,    0}, {   0,    0,    0,    0,    0,    0,    0, 12.0, 15.0}},
            /*16*/ {{   0,    0,    0,    0,    0,    0,    0,    0,    0}, {   0,    0,    0,    0,    0,    0,    0, 12.6, 15.6}},
            /*17*/ {{   0,    0,    0,    0,    0,    0,    0,    0,    0}, {   0,    0,    0,    0,    0,    0,  3.0, 13.0, 16.0}},
            /*18*/ {{   0,    0,    0,    0,    0,    0,    0,    0,    0}, {   0,    0,    0,    0,    0,    0,  6.0, 13.6, 16.4}},
            /*19*/ {{   0,    0,    0,    0,    0,    0,    0,    0,  3.0}, {   0,    0,    0,    0,    0,  3.0,  9.0, 14.0, 16.6}},
            /*20*/ {{   0,    0,    0,    0,    0,    0,    0,    0,  6.0}, {   0,    0,    0,    0,    0,  6.0, 12.0, 14.6, 16.8}},
            /*21*/ {{   0,    0,    0,    0,    0,    0,    0,    0,  9.0}, {   0,    0,    0,    0,  3.0,  9.0, 13.0, 15.0, 17.0}},
            /*22*/ {{   0,    0,    0,    0,    0,    0,    0,  3.0, 12.0}, {   0,    0,    0,    0,  6.0, 12.0, 14.0, 16.0, 17.2}},
            /*23*/ {{   0,    0,    0,    0,    0,    0,    0,  6.0, 12.6}, {   0,    0,    0,    0,  9.0, 16.0, 15.0, 17.0, 17.4}},
            /*24*/ {{   0,    0,    0,    0,    0,    0,    0,  9.0, 13.0}, {   0,    0,    0,  3.0, 12.0, 16.4, 16.0, 17.2, 17.6}},
            /*25*/ {{   0,    0,    0,    0,    0,    0,  3.0, 12.0, 13.6}, {   0,    0,    0,  6.0, 12.8, 16.6, 17.0, 17.6, 17.8}},
            /*26*/ {{   0,    0,    0,    0,    0,    0,  6.0, 12.6, 14.0}, {   0,    0,  3.0,  9.0, 13.6, 17.0, 17.2, 17.8, 18.0}},
            /*27*/ {{   0,    0,    0,    0,    0,    0,  9.0, 13.0, 14.6}, {   0,    0,  6.0, 12.0, 14.0, 17.6, 17.6, 18.0, 18.8}},
            /*28*/ {{   0,    0,    0,    0,    0,  3.0, 12.0, 13.6, 15.0}, {   0,    0,  9.0, 13.0, 15.0, 18.0, 17.8, 19.0, 19.0}},
            /*29*/ {{   0,    0,    0,    0,    0,  6.0, 12.6, 14.0, 15.6}, {   0,    0, 12.0, 13.6, 16.0, 18.2, 18.0, 19.2, 19.4}},
            /*30*/ {{   0,    0,    0,    0,    0,  9.0, 13.0, 14.6, 16.0}, {   0,    0, 13.0, 14.0, 16.4, 18.4, 19.0, 19.4, 19.7}},
            /*31*/ {{   0,    0,    0,    0,  3.0, 12.0, 14.0, 15.0, 17.0}, {   0,  3.0, 13.6, 15.0, 16.6, 18.8, 19.5, 19.7, 20.0}},
            /*32*/ {{   0,    0,    0,    0,  6.0, 13.0, 14.6, 15.6, 17.2}, {   0,  6.0, 14.0, 15.6, 17.0, 19.0, 20.0, 20.0, 20.0}},
            /*33*/ {{   0,    0,    0,    0,  9.0, 14.0, 15.0, 16.0, 17.6}, {   0,  9.0, 15.0, 16.0, 17.6, 19.4, 20.0, 20.0, 20.0}},
            /*34*/ {{   0,    0,    0,  3.0, 12.0, 15.0, 15.6, 17.0, 17.8}, {   0, 12.0, 15.6, 16.4, 18.0, 19.7, 20.0, 20.0, 20.0}},
            /*35*/ {{   0,    0,    0,  6.0, 13.0, 15.6, 16.0, 17.4, 18.0}, { 3.0, 12.6, 16.0, 16.6, 18.2, 20.0, 20.0, 20.0, 20.0}},
            /*36*/ {{   0,    0,  3.0,  9.0, 14.0, 16.0, 17.0, 17.6, 18.2}, { 6.0, 13.0, 16.4, 17.0, 18.4, 20.0, 20.0, 20.0, 20.0}},
            /*37*/ {{   0,    0,  6.0, 12.0, 15.0, 16.6, 17.4, 18.0, 18.4}, { 9.0, 13.6, 16.6, 17.6, 18.8, 20.0, 20.0, 20.0, 20.0}},
            /*38*/ {{   0,  3.0,  9.0, 13.0, 15.6, 17.0, 17.6, 18.2, 18.8}, {12.0, 14.0, 17.0, 18.0, 19.0, 20.0, 20.0, 20.0, 20.0}},
            /*39*/ {{ 3.0,  6.0, 12.0, 14.0, 16.0, 17.4, 18.0, 18.4, 19.0}, {13.0, 14.6, 17.6, 18.8, 19.4, 20.0, 20.0, 20.0, 20.0}},
            /*40*/ {{ 6.0,  9.0, 13.0, 15.0, 17.0, 17.6, 18.2, 18.8, 19.4}, {13.6, 15.0, 18.0, 19.0, 19.7, 20.0, 20.0, 20.0, 20.0}},
            /*41*/ {{ 9.0, 12.0, 14.0, 16.0, 17.4, 18.0, 18.4, 19.0, 19.7}, {14.0, 15.6, 18.8, 19.4, 20.0, 20.0, 20.0, 20.0, 20.0}},
            /*42*/ {{12.0, 12.8, 15.0, 16.6, 17.6, 18.4, 18.8, 19.4, 20.0}, {15.0, 16.0, 19.0, 19.7, 20.0, 20.0, 20.0, 20.0, 20.0}},
            /*43*/ {{12.8, 13.0, 16.0, 17.0, 18.0, 18.8, 19.0, 19.7, 20.0}, {15.6, 17.0, 19.4, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}},
            /*44*/ {{13.0, 14.0, 16.6, 17.4, 18.2, 19.0, 19.4, 20.0, 20.0}, {16.0, 17.2, 19.7, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}},
            /*45*/ {{14.0, 15.0, 17.0, 17.6, 18.4, 19.2, 19.7, 20.0, 20.0}, {17.0, 17.8, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}},
            /*46*/ {{15.0, 16.0, 17.4, 18.0, 18.8, 19.4, 20.0, 20.0, 20.0}, {17.2, 18.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}},
            /*47*/ {{16.0, 16.6, 17.6, 18.4, 19.0, 19.7, 20.0, 20.0, 20.0}, {17.6, 18.8, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}},
            /*48*/ {{16.6, 17.0, 18.0, 18.8, 19.4, 20.0, 20.0, 20.0, 20.0}, {17.8, 19.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}},
            /*49*/ {{17.0, 17.4, 18.4, 19.0, 19.7, 20.0, 20.0, 20.0, 20.0}, {18.0, 19.5, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}},
            /*50*/ {{17.4, 17.6, 18.8, 19.4, 20.0, 20.0, 20.0, 20.0, 20.0}, {18.8, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}},
            /*51*/ {{17.6, 18.0, 19.0, 19.7, 20.0, 20.0, 20.0, 20.0, 20.0}, {19.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}},
            /*52*/ {{18.0, 18.4, 19.4, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}, {19.4, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}},
            /*53*/ {{18.4, 18.8, 19.7, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}, {19.7, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}},
            /*54*/ {{18.8, 19.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}, {20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}},
            /*55*/ {{19.0, 19.5, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}, {20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}},
            /*56*/ {{19.4, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}, {20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}},
            /*57*/ {{19.7, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}, {20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}},
            /*58*/ {{20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}, {20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0}}
    };
    public static final double RUN[][][] = { // [timeIndex][GenderIndex][AgeIndex]
            /* TIME       M20   M25   M30   M35   M40   M45   M50   M55   M60     F20   F25   F30   F35   F40   F45   F50   F55   F60 */
            /*  9:12 */ {{60.0, 60.0, 60.0, 60.0, 60.0, 60.0, 60.0, 60.0, 60.0}, {60.0, 60.0, 60.0, 60.0, 60.0, 60.0, 60.0, 60.0, 60.0}},
            /*  9:22 */ {{59.5, 60.0, 60.0, 60.0, 60.0, 60.0, 60.0, 60.0, 60.0}, {60.0, 60.0, 60.0, 60.0, 60.0, 60.0, 60.0, 60.0, 60.0}},
            /*  9:34 */ {{59.5, 59.5, 60.0, 60.0, 60.0, 60.0, 60.0, 60.0, 60.0}, {60.0, 60.0, 60.0, 60.0, 60.0, 60.0, 60.0, 60.0, 60.0}},
            /*  9:45 */ {{58.5, 59.5, 59.5, 60.0, 60.0, 60.0, 60.0, 60.0, 60.0}, {60.0, 60.0, 60.0, 60.0, 60.0, 60.0, 60.0, 60.0, 60.0}},
            /*  9:58 */ {{58.5, 59.0, 59.5, 59.5, 60.0, 60.0, 60.0, 60.0, 60.0}, {60.0, 60.0, 60.0, 60.0, 60.0, 60.0, 60.0, 60.0, 60.0}},
            /* 10:10 */ {{58.0, 58.5, 59.0, 59.5, 59.5, 60.0, 60.0, 60.0, 60.0}, {60.0, 60.0, 60.0, 60.0, 60.0, 60.0, 60.0, 60.0, 60.0}},
            /* 10:23 */ {{57.5, 58.0, 58.5, 59.0, 59.5, 59.5, 60.0, 60.0, 60.0}, {60.0, 60.0, 60.0, 60.0, 60.0, 60.0, 60.0, 60.0, 60.0}},
            /* 10:37 */ {{57.0, 57.5, 58.0, 58.5, 59.0, 59.5, 60.0, 60.0, 60.0}, {59.5, 60.0, 60.0, 60.0, 60.0, 60.0, 60.0, 60.0, 60.0}},
            /* 10:51 */ {{56.5, 57.0, 57.5, 58.0, 58.5, 59.0, 59.5, 60.0, 60.0}, {59.5, 59.5, 60.0, 60.0, 60.0, 60.0, 60.0, 60.0, 60.0}},
            /* 11:06 */ {{56.0, 56.5, 57.0, 57.5, 58.0, 58.5, 59.5, 59.5, 60.0}, {59.0, 59.5, 59.5, 60.0, 60.0, 60.0, 60.0, 60.0, 60.0}},
            /* 11:22 */ {{55.5, 56.0, 56.5, 57.0, 57.5, 58.0, 59.0, 59.5, 60.0}, {58.5, 59.0, 59.5, 59.5, 60.0, 60.0, 60.0, 60.0, 60.0}},
            /* 11:38 */ {{55.0, 55.5, 56.0, 56.5, 57.0, 57.5, 58.5, 59.0, 59.5}, {58.0, 58.5, 59.0, 59.5, 59.5, 60.0, 60.0, 60.0, 60.0}},
            /* 11:56 */ {{54.5, 55.0, 55.5, 56.0, 56.5, 57.0, 58.0, 58.5, 59.5}, {57.5, 58.0, 58.5, 59.0, 59.5, 59.5, 60.0, 60.0, 60.0}},
            /* 12:14 */ {{54.0, 54.5, 55.0, 55.5, 56.0, 56.5, 57.5, 58.0, 59.0}, {57.0, 57.5, 58.0, 58.5, 59.0, 59.5, 60.0, 60.0, 60.0}},
            /* 12:33 */ {{53.5, 54.0, 54.5, 55.0, 55.5, 56.0, 57.0, 57.5, 58.8}, {56.5, 57.0, 57.5, 58.0, 58.5, 59.0, 60.0, 60.0, 60.0}},
            /* 12:53 */ {{52.0, 53.5, 54.0, 54.5, 55.0, 55.5, 56.5, 57.0, 58.0}, {56.0, 56.5, 57.0, 57.5, 58.0, 58.5, 60.0, 60.0, 60.0}},
            /* 13:14 */ {{50.5, 52.0, 53.5, 54.0, 54.5, 55.0, 56.0, 56.5, 57.5}, {55.5, 56.0, 56.5, 57.0, 57.5, 58.0, 59.5, 60.0, 60.0}},
            /* 13:36 */ {{49.0, 50.5, 52.0, 53.5, 54.0, 54.5, 55.5, 56.0, 57.0}, {55.0, 55.5, 56.0, 56.5, 57.0, 57.5, 59.5, 59.5, 60.0}},
            /* 14:00 */ {{46.5, 49.0, 50.5, 52.0, 53.5, 54.0, 55.0, 55.5, 56.5}, {54.5, 55.0, 55.5, 56.0, 56.5, 57.0, 59.0, 59.5, 60.0}},
            /* 14:25 */ {{44.0, 46.5, 48.0, 50.5, 52.0, 53.5, 54.5, 55.0, 56.0}, {54.0, 54.5, 55.0, 55.5, 56.0, 56.5, 58.5, 59.0, 59.5}},
            /* 14:52 */ {{41.0, 44.0, 45.5, 48.0, 50.5, 52.0, 54.0, 54.5, 55.5}, {53.5, 54.0, 54.5, 55.0, 55.5, 56.0, 58.0, 58.5, 59.5}},
            /* 15:20 */ {{38.0, 41.0, 43.0, 45.5, 49.0, 50.5, 53.5, 54.0, 55.0}, {52.0, 53.5, 54.0, 54.5, 55.0, 55.5, 57.5, 58.0, 59.0}},
            /* 15:50 */ {{35.0, 38.0, 40.5, 43.0, 46.5, 49.0, 52.0, 53.5, 54.5}, {50.5, 52.0, 52.5, 54.0, 54.5, 55.0, 57.0, 57.5, 58.5}},
            /* 16:22 */ {{   0, 35.0, 38.0, 40.5, 44.0, 46.5, 50.5, 52.0, 54.0}, {49.0, 50.5, 51.0, 52.5, 54.0, 54.5, 55.5, 57.0, 58.0}},
            /* 16:57 */ {{   0,    0, 35.0, 38.0, 41.0, 44.0, 48.0, 50.5, 52.5}, {46.0, 49.0, 49.5, 51.0, 53.5, 54.0, 55.0, 56.5, 57.5}},
            /* 17:33 */ {{   0,    0,    0, 35.0, 38.0, 41.0, 45.5, 48.0, 51.0}, {42.5, 45.5, 47.0, 49.5, 52.0, 53.5, 54.5, 56.0, 57.0}}, //* 17:34 is altitude and F20/F60 break; M50 has error in chart at 17:34
            /* 18:14 */ {{   0,    0,    0,    0, 35.0, 38.0, 43.0, 45.5, 49.5}, {39.0, 42.0, 44.5, 47.0, 50.5, 52.0, 54.0, 55.5, 56.5}},
            /* 18:56 */ {{   0,    0,    0,    0,    0, 35.0, 40.5, 43.0, 47.0}, {35.0, 38.5, 42.0, 44.0, 48.0, 50.5, 53.5, 55.0, 56.0}},
            /* 19:43 */ {{   0,    0,    0,    0,    0,    0, 38.0, 40.5, 44.5}, {   0, 35.0, 38.5, 41.0, 45.5, 48.0, 52.0, 53.5, 55.5}},
            /* 20:33 */ {{   0,    0,    0,    0,    0,    0, 35.0, 38.0, 41.5}, {   0,    0, 35.0, 38.0, 42.0, 45.0, 49.5, 52.0, 54.0}},
            /* 21:28 */ {{   0,    0,    0,    0,    0,    0,    0, 35.0, 38.5}, {   0,    0,    0, 35.0, 38.5, 42.0, 46.0, 49.0, 52.5}},
            /* 22:28 */ {{   0,    0,    0,    0,    0,    0,    0,    0, 35.0}, {   0,    0,    0,    0, 35.0, 38.5, 42.5, 46.0, 51.0}},
            /* 23:34 */ {{   0,    0,    0,    0,    0,    0,    0,    0,    0}, {   0,    0,    0,    0,    0, 35.0, 39.0, 43.0, 47.0}},
            /* 24:46 */ {{   0,    0,    0,    0,    0,    0,    0,    0,    0}, {   0,    0,    0,    0,    0,    0, 35.0, 39.0, 43.0}},
            /* 26:06 */ {{   0,    0,    0,    0,    0,    0,    0,    0,    0}, {   0,    0,    0,    0,    0,    0,    0, 35.0, 39.0}},
            /* 27:27 */ {{   0,    0,    0,    0,    0,    0,    0,    0,    0}, {   0,    0,    0,    0,    0,    0,    0,    0, 35.0}},
            /* 23:59 */ {{   0,    0,    0,    0,    0,    0,    0,    0,    0}, {   0,    0,    0,    0,    0,    0,    0,    0,    0}}
    };

    // altitudes above these minimums earn an altitude correction
    public static final int ALTITUDES[] = {5250, 5500, 6000, 6600};
    public static final int ALTITUDE_CORRECTIONS[][] = { // [timeIndex][AltitudeIndex] times below these earn the corresponding correction
            /* 0   1  2   3   4 */
            { 553, 2,  6, 11, 18},
            { 563, 2,  6, 11, 18},
            { 575, 2,  6, 11, 19},
            { 586, 2,  7, 12, 20},
            { 599, 2,  7, 12, 20},
            { 611, 2,  7, 12, 20},
            { 624, 2,  7, 12, 21},
            { 638, 2,  7, 12, 21},
            { 652, 2,  8, 13, 22},
            { 667, 2,  8, 13, 22},
            { 683, 2,  8, 13, 22},
            { 699, 3,  8, 14, 23},
            { 717, 3,  9, 15, 24},
            { 735, 3,  9, 15, 25},
            { 754, 3,  9, 15, 26},
            { 774, 3,  9, 16, 26},
            { 795, 3,  9, 16, 27},
            { 817, 3, 10, 16, 28},
            { 841, 3, 10, 17, 28},
            { 866, 3, 10, 17, 29},
            { 893, 3, 11, 18, 31},
            { 921, 3, 11, 18, 31},
            { 951, 4, 11, 19, 32},
            { 983, 4, 12, 20, 34},
            {1018, 5, 13, 21, 36},
            {1055, 5, 13, 22, 37},
            {1095, 5, 14, 23, 38},
            {1137, 5, 14, 24, 40},
            {1184, 5, 15, 25, 42},
            {1234, 5, 15, 26, 43},
            {1289, 6, 17, 28, 46},
            {1349, 6, 18, 29, 49},
            {1415, 6, 18, 31, 51},
            {1487, 6, 19, 32, 54},
            {1567, 7, 20, 34, 57},
            {9999, 8, 22, 37, 62}
    };
}
