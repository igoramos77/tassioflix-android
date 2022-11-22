package com.example.tassioflix;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieAPI {
    @GET("movie/popular?api_key=1f54bd990f1cdfb230adb312546d765d&language=pt-BR")
    Call<List<Movie>> getMovies();
    //String BASE_URL = "https://api.themoviedb.org/3/";
}
