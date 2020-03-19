package com.softxperttask.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.softxperttask.data.apis.ApiClient;
import com.softxperttask.data.apis.CarApi;
import com.softxperttask.data.models.ApiResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CarRepository {

    ApiClient apiClient = new ApiClient();

    public LiveData<ApiResponse> getCars(int page) {
        final MutableLiveData<ApiResponse> apiResponse = new MutableLiveData<ApiResponse>();
        CarApi apiService = apiClient.getClient().create(CarApi.class);
        Call<ApiResponse> call = apiService.getCars(page);

        call.enqueue(new Callback<ApiResponse>()  {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful()) {
                    apiResponse.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {

            }
        });

        return apiResponse;
    }

}
