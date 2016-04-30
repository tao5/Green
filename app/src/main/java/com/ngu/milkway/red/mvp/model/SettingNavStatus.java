package com.ngu.milkway.red.mvp.model;

import com.ngu.milkway.red.mvp.view.home.impl.HomeFragment;
import com.ngu.milkway.red.mvp.view.home.impl.NavigationActivity;
import com.ngu.milkway.red.mvp.view.setting.impl.SettingFragment;

/**
 * Created by xt on 16/4/30.
 */
public class SettingNavStatus extends NavigateStatus {
    @Override
    public void onNavigationItemSelected(int id, NavigationActivity activity) {
        SettingFragment settingFragment = null;//(SettingFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (settingFragment == null) {
            settingFragment = new SettingFragment();
            activity.showFragment(settingFragment);
        }
    }
}
