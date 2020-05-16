package com.example.webservicebaru.Model.Berita;

import com.google.gson.annotations.SerializedName;

public class BeritaSource {

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private String id;

	public String getName(){
		return name;
	}

	public String getId(){
		return id;
	}
}