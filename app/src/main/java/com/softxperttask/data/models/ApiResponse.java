package com.softxperttask.data.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponse {

    @SerializedName("status")
    public int status;

    @SerializedName("data")
    public List<Car> cars;
}
