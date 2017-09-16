package com.gdglima.glabkotlin.gdglimaapp.data.model;

import com.gdglima.glabkotlin.gdglimaapp.model.Speaker;

import java.util.List;

/**
 * Created by emedinaa on 16/09/17.
 */

public class SpeakerResponse extends BaseResponse {

    private List<Speaker> data;

    public List<Speaker> getData() {
        return data;
    }

    public void setData(List<Speaker> data) {
        this.data = data;
    }
}
