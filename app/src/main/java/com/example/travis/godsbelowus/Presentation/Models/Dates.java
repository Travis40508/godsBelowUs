package com.example.travis.godsbelowus.Presentation.Models;

/**
 * Created by travis on 3/1/17.
 */

public class Dates {
    private String date;
    private String time;
    private String location;

    public Dates() {
    }

    public Dates(String date, String time, String location) {
        this.date = date;
        this.time = time;
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
