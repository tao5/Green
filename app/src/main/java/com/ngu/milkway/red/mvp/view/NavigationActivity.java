package com.ngu.milkway.red.mvp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

import com.ngu.milkway.red.R;
import com.ngu.milkway.red.mvp.view.home.impl.HomeFragment;
import com.ngu.milkway.red.mvp.view.setting.impl.SettingFragment;
import com.ngu.milkway.red.utils.ActivityUtils;

/**
 * Created by xt on 16/4/29.
 */
public abstract class NavigationActivity extends BaseActivity implements
        android.support.design.widget.NavigationView.OnNavigationItemSelectedListener, NavigationView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            HomeFragment homeFragment = null;//(HomeFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
            if (homeFragment == null) {
                homeFragment = new HomeFragment();
                showFragment(homeFragment);
            }
        } else if (id == R.id.nav_gallery) {
            SettingFragment settingFragment = null;//(SettingFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
            if (settingFragment == null) {
                settingFragment = new SettingFragment();
                showFragment(settingFragment);
            }
        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public <T extends Fragment> void showFragment(T fragment) {
        ActivityUtils.attachFragment(getSupportFragmentManager(), fragment, R.id.contentFrame);
    }
}
