package com.ngu.milkway.red.mvp.view.setting.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ngu.milkway.red.R;
import com.ngu.milkway.red.mvp.presenter.BasePresenter;
import com.ngu.milkway.red.mvp.view.BaseFragment;
import com.ngu.milkway.red.mvp.view.setting.SettingView;

/**
 * Created by xt on 16/4/29.
 */
public class SettingFragment extends BaseFragment implements SettingView {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fr_setting, container, false);
        return view;
    }

    @Override
    protected int setResource() {
        return R.layout.fr_setting;
    }

    @Override
    protected void initFragment() {

    }

    @Override
    public void setPresenter(BasePresenter presenter) {

    }

}
