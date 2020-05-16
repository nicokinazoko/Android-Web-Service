package com.example.webservicebaru.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.example.webservicebaru.Adapter.BeritaAdapter;
import com.example.webservicebaru.Model.Berita.BeritaDiscoverArticlesItem;
import com.example.webservicebaru.R;
import com.example.webservicebaru.ViewModel.BeritaViewModel;

import java.util.ArrayList;
import java.util.Observable;
import androidx.lifecycle.Observer;

import retrofit2.http.Url;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewBerita;
    private BeritaAdapter beritaAdapter;
    private BeritaViewModel beritaViewModel;

    private ArrayList<BeritaDiscoverArticlesItem> listBeritaArticlesItem                =   new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        beritaAdapter                                                                       =   new BeritaAdapter(this);
        beritaAdapter.notifyDataSetChanged();

        recyclerViewBerita                                                                  =   findViewById(R.id.recycleview_berita);
        recyclerViewBerita.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        beritaViewModel                                                                     =   new ViewModelProvider(this).get(BeritaViewModel.class);
        beritaViewModel.setAllBerita();
        beritaViewModel.getAllBerita().observe(this, getAllBerita);

        recyclerViewBerita.setAdapter(beritaAdapter);

        beritaAdapter.setOnItemCallback(new BeritaAdapter.OnItemCallback() {
            @Override
            public void onItemClicked(BeritaDiscoverArticlesItem beritaDiscoverArticlesItem) {
                Uri webPage                                                                 =   Uri.parse(beritaDiscoverArticlesItem.getUrl());
                Toast.makeText(getApplicationContext(),"You Clicked" + beritaDiscoverArticlesItem.getTitle(),Toast.LENGTH_SHORT).show();
                Intent intent                                                               =   new Intent(Intent.ACTION_VIEW,webPage);
                startActivity(intent);
            }
        });




    }

    private Observer<ArrayList<BeritaDiscoverArticlesItem>> getAllBerita                    =   new Observer<ArrayList<BeritaDiscoverArticlesItem>>() {
        @Override
        public void onChanged(ArrayList<BeritaDiscoverArticlesItem> beritaDiscoverArticlesItems) {
            if(beritaDiscoverArticlesItems != null)
            {
                beritaAdapter.setData(beritaDiscoverArticlesItems);
            }
        }

    };
}
