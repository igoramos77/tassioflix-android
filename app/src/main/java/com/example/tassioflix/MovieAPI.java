package com.example.tassioflix;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieAPI {
    @GET("movie/top_rated?api_key=d37c9166850428d8322358f992a9e3b3&language=pt-BR&page=1")
    Call<List<Movie>> getMovies();
}
