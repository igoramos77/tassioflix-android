package com.example.tassioflix.model.dao;

import com.example.tassioflix.model.entity.Oscar;

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

public class OscarDao {

    private final List<Oscar> oscarList;
    private String responseBody;

    public OscarDao() {
        this.oscarList = new ArrayList<>();
        this.getFromApi();
        this.getOscarMoviesById();
    }

    public void getFromApi() {
        Request.Builder builder = new Request.Builder();
        String KEY = "637d6ad016c1b892ebccc7d3";
        String API_BASE_URL = ".mockapi.io";
        Request request = builder
                .url("https://"+KEY+API_BASE_URL+"/top-rated/oscar")
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

    public List<Oscar> getOscarMoviesById() {
        try {
            JSONArray jsonArray = new JSONArray(responseBody);

            for(int i=0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String name = jsonObject.getString("name");
                String sloganTagLine = jsonObject.getString("tagline");

                oscarList.add(new Oscar(i, name, sloganTagLine));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this.oscarList;
    }

    public Oscar getOscarMoviesById(int id) {
        for (Oscar oscar : this.oscarList) {
            if(oscar.getId() == id) {
                return oscar;
            }
        }
        return null;
    }

}
