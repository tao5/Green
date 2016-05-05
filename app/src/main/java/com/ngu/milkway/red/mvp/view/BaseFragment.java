package com.ngu.milkway.red.mvp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by xt on 16/4/29.
 */
public abstract class BaseFragment extends Fragment {

    protected View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(setResource(), container, false);
        initFragment();
        return view;
    }

    protected abstract int setResource();

    protected abstract void initFragment();

    protected  <T extends BaseFragment> T newInstance(T fragment, String key, String fragmentId) {
        Bundle args = new Bundle();
        args.putString(key, fragmentId);
        fragment.setArguments(args);
        return fragment;
    }

    protected void setSnackbar(String info, int duration) {
        Snackbar.make(view, info, duration).show();
    }

    protected void setSnackbar(String info) {
        setSnackbar(info, Snackbar.LENGTH_SHORT);
    }
}
