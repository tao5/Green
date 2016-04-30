package com.ngu.milkway.red.mvp.view.home.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ngu.milkway.red.R;
import com.ngu.milkway.red.mvp.presenter.home.IHomePresenter;
import com.ngu.milkway.red.mvp.view.BaseFragment;
import com.ngu.milkway.red.mvp.view.home.IHomeView;

/**
 * Created by xt on 16/4/29.
 */
public class HomeFragment extends BaseFragment implements IHomeView {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fr_home, container, false);
        return view;
    }

    @Override
    public void closeDraw() {

    }

    @Override
    public void openDraw() {

    }

    @Override
    public void showFab() {

    }

    @Override
    public void closeFab() {

    }

    @Override
    public void setPresenter(IHomePresenter presenter) {

    }

}
