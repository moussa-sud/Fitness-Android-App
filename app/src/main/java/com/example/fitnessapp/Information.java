package com.example.fitnessapp;

public class Information {
    private String name;

    private int image;


    // Constructor without parameters
    public Information() {
    }

    // Constructor with parameters
    public Information(String name,  int image) {
        this.name = name;

        this.image = image;

    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }


}
