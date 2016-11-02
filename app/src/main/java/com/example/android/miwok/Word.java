package com.example.android.miwok;

/**
 * Created by Brian on 11/1/2016.
 * Represents a vocabulary word in Miwok
 * Contains the Miwok and default transaltions for said word
 */

public class Word {
    // variable to hold Miwok word
    private String miwokTraslation;

    // variable to hold default word
    private String defaultTranslation;

    // public constructor for Word object
    public Word(String defaultWord, String miwokWord) {
        // place defaultWord into defaultTranslation variable
        defaultTranslation = defaultWord;

        // place miwokWord into miwokTranslation variable
        miwokTraslation = miwokWord;
    }

    // function to return Miwok word
    public String getMiwokTraslation() {
        return miwokTraslation;
    }

    // function to return default word
    public String getDefaultTranslation() {
        return defaultTranslation;
    }

}
