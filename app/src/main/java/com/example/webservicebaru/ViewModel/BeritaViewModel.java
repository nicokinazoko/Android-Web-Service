package com.example.webservicebaru.ViewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.webservicebaru.Model.Berita.BeritaDiscoverArticlesItem;
import com.example.webservicebaru.Model.Berita.BeritaResponse;
import com.example.webservicebaru.Service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class    BeritaViewModel extends ViewModel {

    private ApiMain apiMain;

    private MutableLiveData<ArrayList<BeritaDiscoverArticlesItem>> listberitaArticlesItem               =   new MutableLiveData<>();

    public void setAllBerita()
    {
        if (this.apiMain == null)
        {
            apiMain                                                                                     =   new ApiMain();
        }

        apiMain.getApiBerita().getAllBerita().enqueue(new Callback<BeritaResponse>() {
            @Override
            public void onResponse(Call<BeritaResponse> call, Response<BeritaResponse> response) {
                BeritaResponse beritaResponse                                           =   response.body();

                if(beritaResponse != null && beritaResponse.getArticles() != null)
                {
                    ArrayList<BeritaDiscoverArticlesItem> beritaDiscoverArticlesItems                   =   beritaResponse.getArticles();
                    listberitaArticlesItem.postValue(beritaDiscoverArticlesItems);

                }
            }

            @Override
            public void onFailure(Call<BeritaResponse> call, Throwable t) {
                t.getMessage();
                Log.e("Error Data", t.getMessage());
            }
        });
    }

    public LiveData<ArrayList<BeritaDiscoverArticlesItem>> getAllBerita()
    {
        return  listberitaArticlesItem;
    }
}
