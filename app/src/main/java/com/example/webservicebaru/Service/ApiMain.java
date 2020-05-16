package com.example.webservicebaru.Service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiMain {

    private Retrofit retrofit;

    public BeritaRepository getApiBerita()
    {
        String BASE_URL                                     =   "http://newsapi.org/";

        if(retrofit == null)
        {
            retrofit                                        =
                    new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(BeritaRepository.class);
    }
}
