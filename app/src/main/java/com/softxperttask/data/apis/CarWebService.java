package com.softxperttask.data.apis;

import com.softxperttask.data.models.ApiResponse;

import retrofit2.Call;

public class CarWebService {

    ApiClient apiClient;

    public CarWebService(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    Call<ApiResponse> fareRules(int page) {
        return apiClient.getClient().create(CarApi.class).getCars(page);
    }
}
