package com.ngu.milkway.red.mvp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.ngu.milkway.red.R;
import com.ngu.milkway.red.mvp.presenter.home.impl.HomePresenterImpl;
import com.ngu.milkway.red.mvp.presenter.weather.impl.WeatherPresenterImpl;
import com.ngu.milkway.red.mvp.view.home.impl.HomeFragment;
import com.ngu.milkway.red.mvp.view.setting.impl.SettingFragment;
import com.ngu.milkway.red.mvp.view.weather.impl.WeatherFragment;
import com.ngu.milkway.red.utils.ActivityUtils;

/**
 * Created by xt on 16/4/29.
 */
public abstract class NavigationActivity extends BaseActivity implements
        android.support.design.widget.NavigationView.OnNavigationItemSelectedListener, NavigationView {

    private Toolbar mToolbar;
    private Toolbar mNormalToolbar;
    private Toolbar mCollapseToolbar;
    private Fragment mCurrentFragment;
    private DrawerLayout mDrawer;
    private android.support.design.widget.NavigationView mNavigationView;

    public static final int HEAD_NORMAL = 0;
    public static final int HEAD_COLLAPSING = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mNormalToolbar = (Toolbar) findViewById(R.id.normal_toolbar);
        mCollapseToolbar = (Toolbar) findViewById(R.id.collapse_toolbar);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (android.support.design.widget.NavigationView) findViewById(R.id.nav_view);

        // config tool bar and relation widget
        setToolbar(setHeadType());

        // init fab
        initFab();

        // register listener to navigate view
        mNavigationView.setNavigationItemSelectedListener(this);
    }

    protected void setToolbar(int headType) {
        if (headType == HEAD_NORMAL) {
            mToolbar = mNormalToolbar;
        } else if (headType == HEAD_COLLAPSING) {
            mToolbar = mCollapseToolbar;
        }
        initDrawer();
    }

    private void initDrawer() {
        // toolbar
        setSupportActionBar(mToolbar);

        // sync toggle and drawer
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.setDrawerListener(toggle);
        toggle.syncState();
    }

    private void initFab() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.drawer_content_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    protected int setHeadType() {
        return HEAD_NORMAL;
    }

    public abstract void setHeadType(int type);

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_camera) {

            HomeFragment homeFragment = new HomeFragment();
            new HomePresenterImpl(homeFragment);
            showFragment(homeFragment);

        } else if (id == R.id.nav_gallery) {

            WeatherFragment weatherFragment = new WeatherFragment();
            new WeatherPresenterImpl(weatherFragment);
            showFragment(weatherFragment);

        } else if (id == R.id.nav_slideshow) {


        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

            showFragment(new SettingFragment());

        }

        mToolbar.setTitle(item.getTitle());
        mDrawer.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public <T extends Fragment> void showFragment(T fragment) {
        if (mCurrentFragment == null || !isSameFragment(fragment)) {
            ActivityUtils.attachFragment(getSupportFragmentManager(), fragment, R.id.content_frame);
            mCurrentFragment = fragment;
        }
    }

    private boolean isSameFragment(Fragment fragment) {
        return fragment.getClass().getName().equals(mCurrentFragment.getClass().getName());
    }

    @Override
    public void onBackPressed() {
        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
