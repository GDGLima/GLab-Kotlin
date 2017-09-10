package com.gdglima.glabkotlin.gdglimaapp.model;

import java.io.Serializable;

/**
 * Created by emedinaa on 2/09/17.
 */

public class Speaker  implements Serializable{

    private String image;
    private String name;
    private String country;
    private String bio;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
