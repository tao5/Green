package com.ngu.milkway.red.mvp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by xt on 16/4/29.
 */
public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    protected  <T extends BaseFragment> T newInstance(T fragment, String key, String fragmentId) {
        Bundle args = new Bundle();
        args.putString(key, fragmentId);
        fragment.setArguments(args);
        return fragment;
    }
}
