package com.ngu.milkway.red.mvp.presenter.weather.impl;

import com.ngu.milkway.red.GreenRetrofit;
import com.ngu.milkway.red.WeatherApi;
import com.ngu.milkway.red.mvp.model.bean.WeatherData;
import com.ngu.milkway.red.mvp.presenter.weather.WeatherPresenter;
import com.ngu.milkway.red.mvp.view.weather.WeatherView;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.ngu.milkway.red.utils.Red.checkNotNull;

/**
 * Created by xt on 16/5/10.
 */
public class WeatherPresenterImpl implements WeatherPresenter {

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
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<WeatherData>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mWeatherView.showSnackbarHint("error = " + e.toString());
                    }

                    @Override
                    public void onNext(WeatherData weatherData) {
                        mWeatherView.showSnackbarHint(weatherData!=null?weatherData.toString():"error");
                    }
                });
    }
}
