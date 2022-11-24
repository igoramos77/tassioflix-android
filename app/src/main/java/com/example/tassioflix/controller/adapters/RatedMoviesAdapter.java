package com.example.tassioflix.controller.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tassioflix.R;
import com.example.tassioflix.model.entity.Movie;

import java.util.List;

public class RatedMoviesAdapter extends BaseAdapter {

    private List<Movie> movieList;

    public RatedMoviesAdapter(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @Override
    public int getCount() {
        return this.movieList.size();
    }
    @Override
    public Object getItem(int position) {
        return this.movieList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return this.movieList.get(position).getId();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        }

        Movie movie = (Movie) getItem(position);
        TextView movieName = convertView.findViewById(R.id.movieTitle);
        TextView movieSlogan = convertView.findViewById(R.id.movieSlogan);
        ImageView movieImage = convertView.findViewById(R.id.movieImage);
        ImageView movieBackdrop = convertView.findViewById(R.id.movieBackdrop);
        TextView movieDurationFormatted = convertView.findViewById(R.id.durationFormatted);

        movieName.setText(movie.getName());
        movieSlogan.setText(movie.getSlogan());
        movieDurationFormatted.setText(movie.getDuration_formatted());

        // poster
        Glide.with(parent.getContext()).load(movie.getImage()).into(movieImage);
        Glide
                .with(parent.getContext())
                .load(movie.getImage())
                .into((ImageView) convertView.findViewById(R.id.movieImage));

        // backdrop
        Glide.with(parent.getContext()).load(movie.getBackdrop()).into(movieBackdrop);
        Glide
                .with(parent.getContext())
                .load(movie.getBackdrop())
                .into((ImageView) convertView.findViewById(R.id.movieBackdrop));

        return convertView;
    }
}
