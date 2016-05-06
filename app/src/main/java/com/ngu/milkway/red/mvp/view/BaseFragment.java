package com.ngu.milkway.red.mvp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ngu.milkway.red.R;

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
        setHasOptionsMenu(showOptionMenu());
        return view;
    }

    /**
     * config XML layout resource for fragment
     * @return
     */
    protected abstract int setResource();

    protected abstract void initFragment();

    /**
     * show option menu, show custom menu also should
     * override setMenuResource()
     * @return show option menu or not
     */
    protected boolean showOptionMenu() {
        return false;
    }

    /**
     * config menu layout resource
     * @return layout resource
     */
    protected int setMenuResource() {
        return R.menu.home;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(setMenuResource(), menu);
    }


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
