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
public class FamilyFragment extends Fragment {
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

    public FamilyFragment() {
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
        words.add(new Word(getResources().getString(R.string.father), "әpә", R.drawable.family_father, R.raw.family_father));
        words.add(new Word(getResources().getString(R.string.mother), "әṭa", R.drawable.family_mother, R.raw.family_mother));
        words.add(new Word(getResources().getString(R.string.son), "angsi", R.drawable.family_son, R.raw.family_son));
        words.add(new Word(getResources().getString(R.string.daughter), "tune", R.drawable.family_daughter, R.raw.family_daughter));
        words.add(new Word(getResources().getString(R.string.older_brother), "taachi", R.drawable.family_older_brother, R.raw.family_older_brother));
        words.add(new Word(getResources().getString(R.string.younger_brother), "chalitti", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        words.add(new Word(getResources().getString(R.string.older_sister), "teṭe", R.drawable.family_older_sister, R.raw.family_older_sister));
        words.add(new Word(getResources().getString(R.string.younger_sister), "kolliti", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        words.add(new Word(getResources().getString(R.string.grandmother), "ama", R.drawable.family_grandmother, R.raw.family_grandmother));
        words.add(new Word(getResources().getString(R.string.grandfather), "paapa", R.drawable.family_grandfather, R.raw.family_grandfather));

        // Word adapter for handling array to list view
        WordAdapter adapter = new WordAdapter(getActivity(), words, R.color.category_family);

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
