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

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
		
		// create array for number words
		List<Word> words = new ArrayList<>();
		
		// populate array with Word objects for 1 - 10
		words.add(new Word(getResources().getString(R.string.one), "lutti", R.drawable.number_one));
		words.add(new Word(getResources().getString(R.string.two), "otiiko", R.drawable.number_two));
		words.add(new Word(getResources().getString(R.string.three), "tolookosu", R.drawable.number_three));
		words.add(new Word(getResources().getString(R.string.four), "oyyisa", R.drawable.number_four));
		words.add(new Word(getResources().getString(R.string.five), "massokka", R.drawable.number_five));
		words.add(new Word(getResources().getString(R.string.six), "temmokka", R.drawable.number_six));
		words.add(new Word(getResources().getString(R.string.seven), "kenekaku", R.drawable.number_seven));
		words.add(new Word(getResources().getString(R.string.eight), "kawinta", R.drawable.number_eight));
		words.add(new Word(getResources().getString(R.string.nine), "wo'e", R.drawable.number_nine));
		words.add(new Word(getResources().getString(R.string.ten), "na'aacha", R.drawable.number_ten));

		// Word adapter for handling array to list view
		WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);

		// Find list layout by id
		ListView listView = (ListView) findViewById(R.id.list);

		// Populate listView using adapter
        listView.setAdapter(adapter);
		
    }
}
