package com.example.android.miwok;

/**
 * Created by Brian on 11/1/2016.
 * Represents a vocabulary word in Miwok
 * Contains the Miwok and default transaltions for said word
 * Contains associated image for numbers, family, and color categories
 */

public class Word {
    // variable to hold Miwok word
    private String miwokTraslation;

    // variable to hold default word
    private String defaultTranslation;
	
	// variable to hold image resource id
	private int imageResourceId;

    // public constructor for Word object - no image
    public Word(String defaultWord, String miwokWord) {
        // place defaultWord into defaultTranslation variable
        defaultTranslation = defaultWord;

        // place miwokWord into miwokTranslation variable
        miwokTraslation = miwokWord;
    }
	
	// public constructor for word object - with image
	public Word(String defaultWord, String miwokWord, int imageId) {
        // place defaultWord into defaultTranslation variable
        defaultTranslation = defaultWord;

        // place miwokWord into miwokTranslation variable
        miwokTraslation = miwokWord;
		
		// place imageId into imageResourceId
		imageResourceId = imageId;
	}

    // function to return Miwok word
    public String getMiwokTraslation() {
        return miwokTraslation;
    }

    // function to return default word
    public String getDefaultTranslation() {
        return defaultTranslation;
    }
	
	// function to return image id
	public int getImageResourceId() {
		return imageResourceId;
	}

}
