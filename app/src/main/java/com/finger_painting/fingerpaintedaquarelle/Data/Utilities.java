package com.finger_painting.fingerpaintedaquarelle.Data;

/**
 * Created by Milena on 09/10/2017.
 */

public class Utilities {

    // ovde cuvam screen resolution
    protected static float thisScreenResolution;


    // metoda koja setuje screenResolution
    public static void setThisScreenResolution(float n) {
        thisScreenResolution = n;
    }

    public static float getThisScreenResolution() {
        return thisScreenResolution;
    }

    //metoda koja vraca rezoluciju ektrana u xxhdpi formatu
    public static String getScreenResolutionMark() {

        if (thisScreenResolution > 0) {

            if (thisScreenResolution < 1.25) {
                return "mdpi";
            } else if (1.25 <= thisScreenResolution && thisScreenResolution < 1.75) {
                return "hdpi";
            } else if (1.75 <= thisScreenResolution && thisScreenResolution < 2.5) {
                return "xhdpi";
            } else if (2.5 <= thisScreenResolution && thisScreenResolution < 3.5) {
                return "xxhdpi";
            } else if (thisScreenResolution >= 3.5) {
                return "xxxhdpi";
            }

        }
        return null;
    }

}