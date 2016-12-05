/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.media.*;
import android.os.*;
import android.support.v7.app.*;
import android.view.*;
import android.widget.*;
import java.util.*;

public class ColorsActivity extends AppCompatActivity {

	// member variable for media player
	private MediaPlayer mMediaPlayer;
	
	// member variable for media player listener
	private MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
    	@Override
	    // once sound finished playing, release media player
    	public void onCompletion(MediaPlayer mp) {
	    	releaseMediaPlayer();
    	}
    };
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // create array for color words
        final List<Word> words = new ArrayList<>();

        // populate array with Word objects for 1 - 10
        words.add(new Word(getResources().getString(R.string.red), "weṭeṭṭi", R.drawable.color_red, R.raw.color_red));
        words.add(new Word(getResources().getString(R.string.green), "chokokki", R.drawable.color_green, R.raw.color_green));
        words.add(new Word(getResources().getString(R.string.brown), "ṭakaakki", R.drawable.color_brown, R.raw.color_brown));
        words.add(new Word(getResources().getString(R.string.gray), "ṭopoppi", R.drawable.color_gray, R.raw.color_gray));
        words.add(new Word(getResources().getString(R.string.black), "kululli", R.drawable.color_black, R.raw.color_black));
        words.add(new Word(getResources().getString(R.string.white), "kelelli", R.drawable.color_white, R.raw.color_white));
        words.add(new Word(getResources().getString(R.string.dusty_yellow), "ṭopiisә", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        words.add(new Word(getResources().getString(R.string.mustard_yellow), "chiwiiṭә", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

        // Word adapter for handling array to list view
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_colors);

        // Find list layout by id
        ListView listView = (ListView) findViewById(R.id.list);

        // Populate listView using adapter
        listView.setAdapter(adapter);
		
		// click listener for item clicks
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
				// find which item was clicked on
				Word word = words.get(i);
					
				// make sure media player is clear
				releaseMediaPlayer();
				
				// set media player with proper audio resource
				mMediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getAudioResourceId());

				// start media player
				mMediaPlayer.start();
					
				// set on complete listener
				mMediaPlayer.setOnCompletionListener(mOnCompletionListener);
			}
		});
		
    }
	
	// release media player resources
	private void releaseMediaPlayer() {
		// check if media player is initialized
		if (mMediaPlayer != null) {
			// is initialized, release media player
			mMediaPlayer.release();

			// set media player to null
			mMediaPlayer = null;
		}
	}
}
