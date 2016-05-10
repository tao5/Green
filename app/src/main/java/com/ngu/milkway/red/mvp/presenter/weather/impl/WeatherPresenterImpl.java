package com.ngu.milkway.red.mvp.presenter.weather.impl;

import android.util.Log;

import com.ngu.milkway.red.GreenRetrofit;
import com.ngu.milkway.red.WeatherApi;
import com.ngu.milkway.red.mvp.model.bean.WeatherData;
import com.ngu.milkway.red.mvp.presenter.weather.WeatherPresenter;
import com.ngu.milkway.red.mvp.view.weather.WeatherView;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import static com.ngu.milkway.red.utils.Red.checkNotNull;

/**
 * Created by xt on 16/5/10.
 */
public class WeatherPresenterImpl implements WeatherPresenter {

    private static final String TAG = "dawn";
    private WeatherView mWeatherView;

    public WeatherPresenterImpl(WeatherView weatherView) {
        mWeatherView = checkNotNull(weatherView);
        mWeatherView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void prepareData() {
        WeatherApi weatherApi = GreenRetrofit.getInstance().getWeatherApi();
        weatherApi.getWeather("北京", "c2b924090b3640579a6910410a45315e")
                .map(new Func1<WeatherData, WeatherData.Weather>() {
                    @Override
                    public WeatherData.Weather call(WeatherData weatherData) {
                        return weatherData.getWeather().get(0);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<WeatherData.Weather>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mWeatherView.showSnackbarHint("error = " + e.toString());
                    }

                    @Override
                    public void onNext(WeatherData.Weather weather) {
                        String info = "weather = " + (weather != null ? weather.toString() : "error");
                        Log.d(TAG, info);
                        // mWeatherView.showSnackbarHint(info);
                        mWeatherView.showWeather(weather);
                    }
                });
    }
}
