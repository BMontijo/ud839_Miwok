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

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        // create array for color words
        List<Word> words = new ArrayList<>();

        // populate array with Word objects for 1 - 10
        words.add(new Word(getResources().getString(R.string.red), "weṭeṭṭi"));
        words.add(new Word(getResources().getString(R.string.green), "chokokki"));
        words.add(new Word(getResources().getString(R.string.brown), "ṭakaakki"));
        words.add(new Word(getResources().getString(R.string.gray), "ṭopoppi"));
        words.add(new Word(getResources().getString(R.string.black), "kululli"));
        words.add(new Word(getResources().getString(R.string.white), "kelelli"));
        words.add(new Word(getResources().getString(R.string.dusty_yellow), "ṭopiisә"));
        words.add(new Word(getResources().getString(R.string.mustard_yellow), "chiwiiṭә"));

        // Word adapter for handling array to list view
        WordAdapter adapter = new WordAdapter(this, words);

        // Find list layout by id
        ListView listView = (ListView) findViewById(R.id.list);

        // Populate listView using adapter
        listView.setAdapter(adapter);

    }
}
