package com.softxperttask.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.softxperttask.data.models.ApiResponse;
import com.softxperttask.data.CarRepository;

public class CarViewModel extends AndroidViewModel {

    public CarViewModel(@NonNull Application application) {
        super(application);
    }

    private MutableLiveData<ApiResponse> cars = new MutableLiveData();
    private CarRepository repository = new CarRepository();

    LiveData<ApiResponse> getCars(int page) {
        cars = (MutableLiveData<ApiResponse>) repository.getCars(page);
        return cars;
    }
}
