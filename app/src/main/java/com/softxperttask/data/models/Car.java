package com.softxperttask.data.models;

import com.google.gson.annotations.SerializedName;

public class Car {

    @SerializedName("id")
    public int id;

    @SerializedName("brand")
    public String brand;

    @SerializedName("constructionYear")
    public String constructionYear;

    @SerializedName("isUsed")
    public boolean isUsed;

    @SerializedName("imageUrl")
    public String imageUrl;
}
