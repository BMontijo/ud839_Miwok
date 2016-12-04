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
import com.example.android.miwok.*;
import java.util.*;

public class PhrasesActivity extends AppCompatActivity {

	// member variable for media player
	private MediaPlayer mMediaPlayer;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // create array for number words
        final List<Word> words = new ArrayList<>();

        // populate array with Word objects for 1 - 10
        words.add(new Word(getResources().getString(R.string.where_going), "minto wuksus?", R.raw.phrase_where_are_you_going));
        words.add(new Word(getResources().getString(R.string.what_name), "tinnә oyaase'nә?", R.raw.phrase_what_is_your_name));
        words.add(new Word(getResources().getString(R.string.name_is), "oyaaset\u2026", R.raw.phrase_my_name_is));
        words.add(new Word(getResources().getString(R.string.how_feeling), "michәksәs?", R.raw.phrase_how_are_you_feeling));
        words.add(new Word(getResources().getString(R.string.feeling_good), "kuchi achit.", R.raw.phrase_im_feeling_good));
        words.add(new Word(getResources().getString(R.string.coming), "әәnәs'aa?", R.raw.phrase_are_you_coming));
        words.add(new Word(getResources().getString(R.string.yes_coming), "hәә’ әәnәm.", R.raw.phrase_yes_im_coming));
        words.add(new Word(getResources().getString(R.string.im_coming), "әәnәm.", R.raw.phrase_im_coming));
        words.add(new Word(getResources().getString(R.string.lets_go), "yoowutis.", R.raw.phrase_lets_go));
        words.add(new Word(getResources().getString(R.string.come_here), "әnni'nem", R.raw.phrase_come_here));

        // Word adapter for handling array to list view
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_phrases);

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

					// set media player with proper audio resource
					mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getAudioResourceId());

					// start media player
					mMediaPlayer.start();
				}
			});

    }
}
