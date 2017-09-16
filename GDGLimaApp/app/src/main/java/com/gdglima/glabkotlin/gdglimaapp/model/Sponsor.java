package com.gdglima.glabkotlin.gdglimaapp.model;

import java.io.Serializable;

/**
 * Created by emedinaa on 16/09/17.
 */

public class Sponsor implements Serializable {

    private enum ItemType{
        HEADER, SPONSOR
    }
    private String title;
    private String image;
    private ItemType type;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }
}
