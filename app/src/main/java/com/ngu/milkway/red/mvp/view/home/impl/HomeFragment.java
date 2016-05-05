package com.ngu.milkway.red.mvp.view.home.impl;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.ngu.milkway.red.R;
import com.ngu.milkway.red.adapter.FlowAdapter;
import com.ngu.milkway.red.mvp.presenter.home.HomePresenter;
import com.ngu.milkway.red.mvp.view.BaseFragment;
import com.ngu.milkway.red.mvp.view.home.HomeView;

import java.util.List;

import static com.ngu.milkway.red.utils.Red.checkNotNull;

/**
 * Created by xt on 16/4/29.
 */
public class HomeFragment extends BaseFragment implements HomeView {

    private RecyclerView imageFlow;

    private HomePresenter mPresenter;

    @Override
    protected int setResource() {
        return R.layout.fr_home;
    }

    @Override
    protected void initFragment() {
        imageFlow = (RecyclerView) view.findViewById(R.id.rv_home_image_flow);
        imageFlow.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL));
        mPresenter.prepareData();
    }

    @Override
    public void setPresenter(HomePresenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void showImageFlow(List<String> urls) {
        imageFlow.setAdapter(new FlowAdapter(urls));
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
    public void showSnackbar(String info) {
        setSnackbar(info, Snackbar.LENGTH_LONG);
    }

}
