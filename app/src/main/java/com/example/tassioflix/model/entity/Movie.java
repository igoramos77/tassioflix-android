package com.example.tassioflix.model.entity;

public class Movie {

    private int id;
    private String name;
    private String slogan;
    private String image;
    private String duration_formatted;
    private String backdrop;

    public Movie(int id, String name, String slogan, String image, String duration_formatted, String backdrop) {
        this.id = id;
        this.name = name;
        this.slogan = slogan;
        this.image = image;
        this.backdrop = backdrop;
        this.duration_formatted = duration_formatted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBackdrop() {
        return backdrop;
    }

    public void setBackdrop(String backdrop) {
        this.backdrop = backdrop;
    }

    public String getDuration_formatted() {
        return duration_formatted;
    }

    public void setDuration_formatted(String duration_formatted) {
        this.duration_formatted = duration_formatted;
    }
}
