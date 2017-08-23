package com.example.android1.recyclerview;

/**
 * Created by Android1 on 8/22/2017.
 */

public class MovieModel {
    private String title, genre, year;

    MovieModel(String title, String genre, String year) {
        this.title=title;
        this.genre=genre;
        this.year=year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
