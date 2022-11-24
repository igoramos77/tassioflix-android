package com.example.tassioflix.model.dao;

import com.example.tassioflix.model.entity.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RatedMoviesDao {

    private final List<Movie> movieList;
    private String responseBody;

    public RatedMoviesDao() {
        this.movieList = new ArrayList<>();
        this.getFromApi();
        this.getMoviesList();
    }

    public void getFromApi() {
        Request.Builder builder = new Request.Builder();
        String KEY = "637d6ad016c1b892ebccc7d3";
        String API_BASE_URL = ".mockapi.io";
        Request request = builder
                .url("https://"+KEY+API_BASE_URL+"/top-rated/movies")
                .get()
                .build();
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        try {
            Response response = client.newCall(request).execute();
            assert response.body() != null;
            this.responseBody = Objects.requireNonNull(response.body()).string();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Movie> getMoviesList() {
        try {
            JSONArray jsonArray = new JSONArray(responseBody);

            for(int i=0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int id = Integer.parseInt(jsonObject.getString("id"));
                String name = jsonObject.getString("name");
                String tagline = jsonObject.getString("tagline");
                String cover = jsonObject.getString("cover");
                String duration_formatted = jsonObject.getString("duration_formatted");
                String backdrop = jsonObject.getString("backdrop");

                movieList.add(new Movie(id, name, tagline, cover, duration_formatted, backdrop));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this.movieList;
    }

    public Movie getMovieById(int id) {
        for (Movie movie : this.movieList) {
            if(movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }

}
