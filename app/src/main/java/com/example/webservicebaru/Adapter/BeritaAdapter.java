package com.example.webservicebaru.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.webservicebaru.Model.Berita.BeritaDiscoverArticlesItem;
import com.example.webservicebaru.R;

import java.util.ArrayList;

public class BeritaAdapter extends RecyclerView.Adapter<BeritaAdapter.ViewHolder> {
    private ArrayList <BeritaDiscoverArticlesItem> beritaArticlesItems                  =   new ArrayList<>();

    private Context context;

    private String BASE_URL                                                     =   "";

    private OnItemCallback onItemCallback;

    public BeritaAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<BeritaDiscoverArticlesItem> items)
    {
        beritaArticlesItems.clear();
        beritaArticlesItems.addAll(items);
        notifyDataSetChanged();
    }

    public void setOnItemCallback(OnItemCallback onItemCallback) {
        this.onItemCallback = onItemCallback;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view                                                                   =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_berita,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        Glide.with(context)
                .load(beritaArticlesItems
                .get(position).getUrlToImage())
                .into(holder.imageViewBerita);

        holder.textViewJudul.setText(beritaArticlesItems.get(position).getTitle().toString());

        holder.textViewPenulis.setText(beritaArticlesItems.get(position).getAuthor().toString());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemCallback.onItemClicked(beritaArticlesItems.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewBerita;
        TextView textViewJudul;
        TextView textViewPenulis;
        CardView cardViewBerita;

        public ViewHolder(View view) {
            super(view);

            imageViewBerita                                                                 =   view.findViewById(R.id.imageview_image);
            textViewJudul                                                                   =   view.findViewById(R.id.textview_title);
            textViewPenulis                                                                 =   view.findViewById(R.id.textview_author);
            cardViewBerita                                                                  =   view.findViewById(R.id.cardview_item);
        }
    }


    public interface OnItemCallback {
        void onItemClicked(BeritaDiscoverArticlesItem beritaDiscoverArticlesItem);
    }
}
