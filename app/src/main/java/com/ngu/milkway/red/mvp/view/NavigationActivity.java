package com.ngu.milkway.red.mvp.view;

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
import com.ngu.milkway.red.mvp.view.home.impl.HomeFragment;
import com.ngu.milkway.red.mvp.view.setting.impl.SettingFragment;
import com.ngu.milkway.red.utils.ActivityUtils;

/**
 * Created by xt on 16/4/29.
 */
public abstract class NavigationActivity extends BaseActivity implements
        android.support.design.widget.NavigationView.OnNavigationItemSelectedListener, NavigationView {

    private Toolbar mToolbar;
    private Fragment mCurrentFragment;
    private DrawerLayout mDrawer;

    protected static final int HEAD_NORMAL = 0;
    protected static final int HEAD_COLLAPSING = 1;

    @Override
    protected void initActivity() {

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.drawer_content_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        android.support.design.widget.NavigationView navigationView = (android.support.design.widget.NavigationView) findViewById(R.id.nav_view);
//        View normalHead = findViewById(R.id.drawer_content_head_normal);
//        View collapsingHead = findViewById(R.id.drawer_content_head_collapsing);
//        ViewFlipper viewFlipper = (ViewFlipper) findViewById(R.id.drawer_content_view_flipper);

        // toolbar
        setSupportActionBar(mToolbar);

        // sync toggle and drawer
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.setDrawerListener(toggle);
        toggle.syncState();

        // register listener to navigate view
        navigationView.setNavigationItemSelectedListener(this);

        // config head
        int headType = setHeadType();
        if (headType == HEAD_NORMAL) {
//            normalHead.setVisibility(View.VISIBLE);
//            collapsingHead.setVisibility(View.GONE);
//            viewFlipper.setDisplayedChild(HEAD_NORMAL);
        } else if (headType == HEAD_COLLAPSING) {
//            normalHead.setVisibility(View.GONE);
//            collapsingHead.setVisibility(View.VISIBLE);
//            viewFlipper.setDisplayedChild(HEAD_COLLAPSING);
        }

//        viewFlipper.setDisplayedChild(2);
    }

    protected int setHeadType() {
        return HEAD_NORMAL;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_camera) {

            HomeFragment homeFragment = new HomeFragment();
            new HomePresenterImpl(homeFragment);
            showFragment(homeFragment);

        } else if (id == R.id.nav_gallery) {

            showFragment(new SettingFragment());

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

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
