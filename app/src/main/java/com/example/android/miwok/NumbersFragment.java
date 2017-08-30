package com.example.android.miwok;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumbersFragment extends Fragment {
    // member variable for media player
    private MediaPlayer mMediaPlayer;

    // member variable for audio focus
    private AudioManager mAudioManager;

    // member variable for media player listener
    private MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        // once sound finished playing, release media player
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    // member variable for audio focus listener
    private AudioManager.OnAudioFocusChangeListener mAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange)
        {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // transient audio focus loss, pause
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // audio focus gain, resume
                mMediaPlayer.start();
            }else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // audio focus loss, release media player
                releaseMediaPlayer();
            }
        }
    };

    public NumbersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        // setup audio manager
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        // create array for number words
        final List<Word> words = new ArrayList<>();

        // populate array with Word objects for 1 - 10
        words.add(new Word(getResources().getString(R.string.one), "lutti", R.drawable.number_one, R.raw.number_one));
        words.add(new Word(getResources().getString(R.string.two), "otiiko", R.drawable.number_two, R.raw.number_two));
        words.add(new Word(getResources().getString(R.string.three), "tolookosu", R.drawable.number_three, R.raw.number_three));
        words.add(new Word(getResources().getString(R.string.four), "oyyisa", R.drawable.number_four, R.raw.number_four));
        words.add(new Word(getResources().getString(R.string.five), "massokka", R.drawable.number_five, R.raw.number_five));
        words.add(new Word(getResources().getString(R.string.six), "temmokka", R.drawable.number_six, R.raw.number_six));
        words.add(new Word(getResources().getString(R.string.seven), "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word(getResources().getString(R.string.eight), "kawinta", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word(getResources().getString(R.string.nine), "wo'e", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word(getResources().getString(R.string.ten), "na'aacha", R.drawable.number_ten, R.raw.number_ten));

        // Word adapter for handling array to list view
        WordAdapter adapter = new WordAdapter(getActivity(), words, R.color.category_numbers);

        // Find list layout by id
        ListView listView = (ListView) rootView.findViewById(R.id.list);

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

                // request audio focus
                int audioRequest = mAudioManager.requestAudioFocus(mAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                //if request success
                if (audioRequest == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                    // set media player with proper audio resource
                    mMediaPlayer = MediaPlayer.create(getActivity(), word.getAudioResourceId());

                    // start media player
                    mMediaPlayer.start();

                    // set on complete listener
                    mMediaPlayer.setOnCompletionListener(mOnCompletionListener);
                }
            }
        });

        return rootView;
    }

    @Override
    public void onStop()
    {
        super.onStop();

        // release media player resources
        releaseMediaPlayer();
    }

    // release media player resources
    private void releaseMediaPlayer() {
        // check if media player is initialized
        if (mMediaPlayer != null) {
            // is initialized, release media player
            mMediaPlayer.release();

            // set media player to null
            mMediaPlayer = null;

            // abandon audio focus
            mAudioManager.abandonAudioFocus(mAudioFocusChangeListener);
        }
    }

}
