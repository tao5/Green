package com.ngu.milkway.red.mvp.model;

import com.ngu.milkway.red.mvp.view.home.impl.HomeFragment;
import com.ngu.milkway.red.mvp.view.home.impl.NavigationActivity;

/**
 * Created by xt on 16/4/30.
 */
public class HomeNavStatus extends NavigateStatus {
    @Override
    public void onNavigationItemSelected(int id, NavigationActivity activity) {
        HomeFragment homeFragment = null;//(HomeFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (homeFragment == null) {
            homeFragment = new HomeFragment();
            activity.showFragment(homeFragment);
        }
    }
}
