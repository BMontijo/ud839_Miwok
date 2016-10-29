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
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
		
		// create array for number words
		List<String> words = new ArrayList<>();
		
		// populate array with words for 1 - 10
		words.add(getResources().getString(R.string.one));
		words.add(getResources().getString(R.string.two));
		words.add(getResources().getString(R.string.three));
		words.add(getResources().getString(R.string.four));
		words.add(getResources().getString(R.string.five));
		words.add(getResources().getString(R.string.six));
		words.add(getResources().getString(R.string.seven));
		words.add(getResources().getString(R.string.eight));
		words.add(getResources().getString(R.string.nine));
		words.add(getResources().getString(R.string.ten));

		ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, words);

		ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
		
    }
}
