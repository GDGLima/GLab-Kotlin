package com.gdglima.glabkotlin.gdglimaapp.data.model;

import com.gdglima.glabkotlin.gdglimaapp.model.Sponsor;

import java.util.List;

/**
 * Created by emedinaa on 16/09/17.
 */

public class SponsorResponse extends BaseResponse {

    private List<Sponsor> data;

    public List<Sponsor> getData() {
        return data;
    }

    public void setData(List<Sponsor> data) {
        this.data = data;
    }
}
