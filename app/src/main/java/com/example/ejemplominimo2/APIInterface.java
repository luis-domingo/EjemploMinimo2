package com.example.ejemplominimo2;

import com.example.ejemplominimo2.models.Museums;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

    @GET("/api/dataset/museus/format/json/pag-ini/1/pag-fi/15")
    Call<Museums> getMuseums();

}
