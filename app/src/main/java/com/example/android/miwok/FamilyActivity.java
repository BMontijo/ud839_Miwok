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

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // create array for number words
        List<Word> words = new ArrayList<>();

        // populate array with Word objects for 1 - 10
        words.add(new Word(getResources().getString(R.string.father), "әpә"));
        words.add(new Word(getResources().getString(R.string.mother), "әṭa"));
        words.add(new Word(getResources().getString(R.string.son), "angsi"));
        words.add(new Word(getResources().getString(R.string.daughter), "tune"));
        words.add(new Word(getResources().getString(R.string.older_brother), "taachi"));
        words.add(new Word(getResources().getString(R.string.younger_brother), "chalitti"));
        words.add(new Word(getResources().getString(R.string.older_sister), "teṭe"));
        words.add(new Word(getResources().getString(R.string.younger_sister), "kolliti"));
        words.add(new Word(getResources().getString(R.string.grandmother), "ama"));
        words.add(new Word(getResources().getString(R.string.grandfather), "paapa"));

        // Word adapter for handling array to list view
        WordAdapter adapter = new WordAdapter(this, words);

        // Find list layout by id
        ListView listView = (ListView) findViewById(R.id.list);

        // Populate listView using adapter
        listView.setAdapter(adapter);

    }
}
