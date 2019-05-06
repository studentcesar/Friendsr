package com.example.friendsr;
import java.io.Serializable;

public class Friend implements Serializable{
    private String name, power;
    private int drawableId;
    private float rating;

    public Friend(String name, String power, int drawableId) {
        this.name = name;
        this.power = power;
        this.drawableId = drawableId;
    }

    public String getName() {
        return name;
    }

    public String getPower() {
        return power;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public float getRating() {
        return rating;
    }

    //setter for the rating field
    public void setRating(float rating) {
        this.rating = rating;
    }
}
