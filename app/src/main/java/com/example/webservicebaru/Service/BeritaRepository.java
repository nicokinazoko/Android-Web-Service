package com.example.webservicebaru.Service;

import com.example.webservicebaru.Model.Berita.BeritaResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BeritaRepository {
    @GET("v2/everything?domains=wsj.com&apiKey=32daf216fbd24267866e2563438db28d")
    Call<BeritaResponse>getAllBerita();
}
