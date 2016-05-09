package com.ngu.milkway.red;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by xt on 16/5/4.
 */
public class GreenRetrofit {

    private MeiziApi meiziApi;
    private WeatherApi weatherApi;

    private static GreenRetrofit retrofit = new GreenRetrofit();

    private GreenRetrofit() {
        Retrofit meiziRetrofit = new Retrofit.Builder()
                .baseUrl("http://gank.io/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        meiziApi = meiziRetrofit.create(MeiziApi.class);

        Retrofit weatherRetrofit = new Retrofit.Builder()
                .baseUrl("https://api.heweather.com/x3/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        weatherApi = weatherRetrofit.create(WeatherApi.class);
    }

    public static GreenRetrofit getInstance() {
        return retrofit;
    }

    public MeiziApi getMeiziApi() {
        return meiziApi;
    }

    public WeatherApi getWeatherApi() {
        return weatherApi;
    }
}
