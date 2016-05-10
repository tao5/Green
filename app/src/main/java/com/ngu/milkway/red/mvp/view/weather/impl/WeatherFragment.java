package com.ngu.milkway.red.mvp.view.weather.impl;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ngu.milkway.red.R;
import com.ngu.milkway.red.adapter.WeatherAdapter;
import com.ngu.milkway.red.mvp.model.bean.WeatherData;
import com.ngu.milkway.red.mvp.presenter.weather.WeatherPresenter;
import com.ngu.milkway.red.mvp.view.BaseFragment;
import com.ngu.milkway.red.mvp.view.weather.WeatherView;

import static com.ngu.milkway.red.mvp.view.NavigationActivity.HEAD_COLLAPSING;
import static com.ngu.milkway.red.utils.Red.checkNotNull;

/**
 * Created by xt on 16/5/9.
 */
public class WeatherFragment extends BaseFragment implements WeatherView {

    private WeatherPresenter mPresenter;
    private RecyclerView mWeatherFlow;
    private WeatherAdapter mWeatherAdapter;

    @Override
    protected int setResource() {
        return R.layout.fr_weather;
    }

    @Override
    protected void initFragment() {
        mWeatherFlow = (RecyclerView) view.findViewById(R.id.rv_weather_flow);
        mWeatherFlow.setLayoutManager(new LinearLayoutManager(getContext()));
        setHeadType(HEAD_COLLAPSING);
        mPresenter.prepareData();
    }

    @Override
    public void setPresenter(WeatherPresenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void showSnackbarHint(String info) {
        setSnackbar(info);
    }

    @Override
    public void showWeather(WeatherData.Weather weather) {
        if (mWeatherAdapter == null) {
            mWeatherAdapter = new WeatherAdapter(weather, getContext());
            mWeatherFlow.setAdapter(mWeatherAdapter);
        } else {
            mWeatherAdapter.update(weather);
        }
    }
}
