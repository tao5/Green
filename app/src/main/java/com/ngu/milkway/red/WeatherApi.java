package com.ngu.milkway.red;

import com.ngu.milkway.red.mvp.model.bean.WeatherData;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by xt on 16/5/1.
 */
public interface WeatherApi {
    @GET("weather")
    Observable<WeatherData> getWeather(@Query("city") String city, @Query("key") String key);

}


