package com.example.travis.godsbelowus.Presentation;

/**
 * Created by travis on 2/19/17.
 */

public interface OnSongListClickListener {

    void playSong(String songId);
    void stopSong(String songId);
    void onlyStopSong();
}
