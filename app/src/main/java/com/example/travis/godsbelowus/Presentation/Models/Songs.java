package com.example.travis.godsbelowus.Presentation.Models;

/**
 * Created by travis on 2/18/17.
 */

public class Songs {
    private String title;
    private int songId;

    public Songs(String title, int songId) {
        this.title = title;
        this.songId = songId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }
}
