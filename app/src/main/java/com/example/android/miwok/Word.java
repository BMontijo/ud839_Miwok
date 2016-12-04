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
	private int imageResourceId = NO_IMAGE;
	
	// constant that shows no image was passed into Word object
	private static final int NO_IMAGE = -1;
	
	// variable to hold audio resource id
	private int audioResourceId;
	
    // public constructor for Word object - no image
    public Word(String defaultWord, String miwokWord, int audioId) {
        // place defaultWord into defaultTranslation variable
        defaultTranslation = defaultWord;

        // place miwokWord into miwokTranslation variable
        miwokTraslation = miwokWord;
		
		// place audioId into audioResourceId
		audioResourceId = audioId;
    }
	
	// public constructor for word object - with image
	public Word(String defaultWord, String miwokWord, int imageId, int audioId) {
        // place defaultWord into defaultTranslation variable
        defaultTranslation = defaultWord;

        // place miwokWord into miwokTranslation variable
        miwokTraslation = miwokWord;
		
		// place imageId into imageResourceId
		imageResourceId = imageId;
		
		// place audioId into audioResourceId
		audioResourceId = audioId;
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
	
	// returns whether an image for this word
	public boolean hasImage() {
		return imageResourceId != NO_IMAGE;
	}
	
	// returns audio resource id for sound playback
	public int getAudioResourceId() {
		return audioResourceId;
	}

}
