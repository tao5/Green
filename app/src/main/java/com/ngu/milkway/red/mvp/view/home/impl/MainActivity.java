package com.ngu.milkway.red.mvp.view.home.impl;

import com.ngu.milkway.red.mvp.presenter.home.impl.HomePresenterImpl;
import com.ngu.milkway.red.mvp.view.CollapsingToolbarActivity;

public class MainActivity extends CollapsingToolbarActivity {

    @Override
    protected void initActivity() {
        HomeFragment homeFragment = new HomeFragment();
        new HomePresenterImpl(homeFragment);
        showFragment(homeFragment);
    }



}
