package com.ngu.milkway.red;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by xt on 16/5/4.
 */
public class GreenRetrofit {

    private GreenApi greenApi;

    private static GreenRetrofit retrofit = new GreenRetrofit();

    private GreenRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://gank.io/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        greenApi = retrofit.create(GreenApi.class);
    }

    public static GreenRetrofit getInstance() {
        return retrofit;
    }

    public GreenApi getGreenApi() {
        return greenApi;
    }
}
