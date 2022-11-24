package com.example.tassioflix.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tassioflix.R;
import com.example.tassioflix.model.dao.RatedMoviesDao;
import com.example.tassioflix.model.entity.Movie;

public class RatedMovieActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_item_inner); // inner page

        Intent intent = getIntent();
        int movie_id = (int) intent.getSerializableExtra("movie_id");

        RatedMoviesDao ratedMoviesDao = new RatedMoviesDao();
        Movie movie = ratedMoviesDao.getMovieById(movie_id);

        TextView movieTitle = findViewById(R.id.movieTitle);
        TextView movieSlogan = findViewById(R.id.movieSlogan);
        ImageView movieImage = findViewById(R.id.movieImage);
        TextView movieDurationFormatted = findViewById(R.id.durationFormatted);
        ImageView movieBackdrop = findViewById(R.id.movieBackdrop);

        movieTitle.setText(movie.getName());
        movieSlogan.setText(movie.getSlogan());
        movieDurationFormatted.setText(movie.getDuration_formatted());

        // images
        Glide.with(this).load(movie.getImage()).into(movieImage);
        Glide.with(this).load(movie.getBackdrop()).into(movieBackdrop);
    }
}
