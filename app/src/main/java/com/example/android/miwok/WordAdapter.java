package com.example.android.miwok;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Brian on 11/1/2016.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    // public constructor, takes activity and list we want to populate it with
    public WordAdapter(Activity context, List<Word> word){
        // initialize the array adapter
        super(context, 0, word);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get Word object at this position
        Word currentWord = getItem(position);

        // check if current view is being reused, otherwise inflate view
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // get layout TextView for default word
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);

        // get default word from Word object and set to view
        defaultTextView.setText(currentWord.getDefaultTranslation());

        // get layout TextView for Miwok word
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);

        // get Miwok word from Word object and set to view
        miwokTextView.setText(currentWord.getMiwokTraslation());

        return listItemView;
    }
}
