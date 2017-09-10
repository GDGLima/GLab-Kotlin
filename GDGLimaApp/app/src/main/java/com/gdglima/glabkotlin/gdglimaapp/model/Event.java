package com.gdglima.glabkotlin.gdglimaapp.model;

import java.io.Serializable;

/**
 * Created by emedinaa on 2/09/17.
 */

public class Event implements Serializable {

    private String time;
    private String activity;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
}
