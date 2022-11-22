package com.example.tassioflix;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tassioflix.databinding.ActivityMainBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static String JSON_URL = "https://api.themoviedb.org/3/movie/popular?api_key=1a2b3c4d5e6f7g8h9i0j&language=pt-BR&page=1";

    List<Movie> movieList;
    RecyclerView recyclerView;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        recyclerView = findViewById(R.id.recyclerView);
        movieList = new ArrayList<>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/") // URL base https://api.themoviedb.org/3/
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MovieAPI movieAPI = retrofit.create(MovieAPI.class);

        Call<List<Movie>> call = movieAPI.getMovies();

        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {

                assert response.body() != null;
                try {
                    JSONObject obj = new JSONObject(response.body().toString());
                    JSONArray results = obj.getJSONArray("results");

                    for(int i = 0; i < results.length(); i++) {
                        movieList.add(
                                new Movie(results.getJSONObject(i).getInt("id"),
                                        results.getJSONObject(i).getString("title"),
                                        results.getJSONObject(i).getString("poster_path"),
                                        results.getJSONObject(i).getString("overview"),
                                        results.getJSONObject(i).getString("release_date"),
                                        results.getJSONObject(i).getString("vote_average"))
                        );
                    }

                    putDataIntoRecyclerView(movieList);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            private void putDataIntoRecyclerView(List<Movie> movieList) {
                Adapter adapter = new Adapter(MainActivity.this, movieList);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }

}