package com.ngu.milkway.red.mvp.view.weather.impl;

import com.ngu.milkway.red.R;
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

    @Override
    protected int setResource() {
        return R.layout.fr_weather;
    }

    @Override
    protected void initFragment() {
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
}
