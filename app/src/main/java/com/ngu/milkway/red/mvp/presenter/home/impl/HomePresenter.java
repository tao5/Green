package com.ngu.milkway.red.mvp.presenter.home.impl;

import com.ngu.milkway.red.mvp.presenter.home.IHomePresenter;
import com.ngu.milkway.red.mvp.view.home.IHomeView;
import com.ngu.milkway.red.utils.Red;

/**
 * Created by xt on 16/4/29.
 */
public class HomePresenter implements IHomePresenter {

    public HomePresenter(IHomeView homeView) {
        Red.checkNotNull(homeView, "HomeView can't be NULL");
        homeView.setPresenter(this);
    }

    @Override
    public void start() {

    }
}
