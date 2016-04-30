package com.ngu.milkway.red.mvp.view.home;

import android.support.v4.app.Fragment;

/**
 * Created by xt on 16/4/29.
 */
public interface INavigationView {
    <T extends Fragment> void showFragment(T fragment);
}
