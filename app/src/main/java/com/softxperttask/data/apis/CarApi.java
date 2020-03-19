package com.softxperttask.data.apis;

import com.softxperttask.data.models.ApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CarApi {

    @GET(ApisConstants.GET_CARS)
    Call<ApiResponse> getCars(@Query("page") int page);
}
