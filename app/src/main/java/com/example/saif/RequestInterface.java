package com.example.saif;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {
    @GET("api.php")
    Call<List<FeedModel>> getEmpoyJson();}