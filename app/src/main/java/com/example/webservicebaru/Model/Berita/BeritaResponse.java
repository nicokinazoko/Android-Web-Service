package com.example.webservicebaru.Model.Berita;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class BeritaResponse{

	@SerializedName("totalResults")
	private int totalResults;

	@SerializedName("articles")
	private ArrayList<BeritaDiscoverArticlesItem> articles;

	@SerializedName("status")
	private String status;

	public int getTotalResults(){
		return totalResults;
	}

	public ArrayList<BeritaDiscoverArticlesItem> getArticles(){
		return articles;
	}

	public String getStatus(){
		return status;
	}
}