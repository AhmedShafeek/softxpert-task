package com.softxperttask.ui;

import android.os.Bundle;

import com.softxperttask.R;
import com.softxperttask.data.models.ApiResponse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class MainActivity extends AppCompatActivity {

    CarViewModel carViewModel = new CarViewModel(getApplication());
    CarAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new CarAdapter();
        subscribeUi(1);

        ((SwipeRefreshLayout) findViewById(R.id.swipe_container)).setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                subscribeUi(2);
            }
        });
    }

    void subscribeUi(int page) {
        carViewModel.getCars(page).observe(this, new Observer<ApiResponse>() {
            @Override
            public void onChanged(ApiResponse apiResponse) {
                ((SwipeRefreshLayout) findViewById(R.id.swipe_container)).setRefreshing(false);
                ((RecyclerView) findViewById(R.id.rv_cars)).setLayoutManager(new LinearLayoutManager(MainActivity.this));
                ((RecyclerView) findViewById(R.id.rv_cars)).setAdapter(adapter);
                adapter.notifyChange(apiResponse.cars);
            }
        });
    }
}
