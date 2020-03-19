package com.softxperttask.data.apis;

import com.softxperttask.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private String baseURL = ApisConstants.BASE_URL;
    private Retrofit retrofit = null;
    private int REQUEST_TIMEOUT = 30;
    private HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

    private OkHttpClient getHttpLogClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient().newBuilder()
                .connectTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS);

        if (BuildConfig.DEBUG) {
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        }
        httpClient.addInterceptor(logging);
        return httpClient.build();
    }

    public Retrofit getClient() {
//        if (retrofit == null) {
        retrofit = new Retrofit.Builder()
                .baseUrl(ApisConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getHttpLogClient())
                .build();
//        }
        return retrofit;
    }
}
