package com.example.tassioflix.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.tassioflix.R;
import com.example.tassioflix.model.dao.OscarDao;
import com.example.tassioflix.model.entity.Oscar;

public class OscarActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oscar_content);

        Intent intent = getIntent();
        int movie_id = (int) intent.getSerializableExtra("movie_id");

        OscarDao oscarDao = new OscarDao();
        Oscar oscar = oscarDao.getOscarMoviesById(movie_id);

        TextView movieName = (TextView) findViewById(R.id.movieName);
        TextView movieSloganTagline = (TextView) findViewById(R.id.movieSloganTagline);

        movieName.setText(oscar.getName());
        movieSloganTagline.setText(oscar.getSloganTagline());
    }
}
