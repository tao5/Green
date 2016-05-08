package com.ngu.milkway.red.mvp.view.home.impl;

import com.ngu.milkway.red.R;
import com.ngu.milkway.red.mvp.presenter.home.impl.HomePresenterImpl;
import com.ngu.milkway.red.mvp.view.NavigationActivity;

public class MainActivity extends NavigationActivity {

    @Override
    protected int setContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initActivity() {
        HomeFragment homeFragment = new HomeFragment();
        new HomePresenterImpl(homeFragment);
        showFragment(homeFragment);
    }



}
