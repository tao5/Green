package com.ngu.milkway.red.mvp.view.home.impl;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.MenuItem;

import com.ngu.milkway.red.R;
import com.ngu.milkway.red.adapter.FlowAdapter;
import com.ngu.milkway.red.mvp.presenter.home.HomePresenter;
import com.ngu.milkway.red.mvp.view.BaseFragment;
import com.ngu.milkway.red.mvp.view.home.HomeView;

import java.util.List;

import static com.ngu.milkway.red.adapter.FlowStyleFactory.FLOW_STYLE_HEIGHT;
import static com.ngu.milkway.red.adapter.FlowStyleFactory.FLOW_STYLE_MIX;
import static com.ngu.milkway.red.adapter.FlowStyleFactory.FLOW_STYLE_WIDTH;
import static com.ngu.milkway.red.utils.Red.checkNotNull;

/**
 * Created by xt on 16/4/29.
 */
public class HomeFragment extends BaseFragment implements HomeView {

    private RecyclerView imageFlow;

    private HomePresenter mPresenter;

    private FlowAdapter mFlowAdapter;

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
        mFlowAdapter = new FlowAdapter(urls);
        imageFlow.setAdapter(mFlowAdapter);
    }

    @Override
    protected boolean showOptionMenu() {
        return true;
    }

    @Override
    protected int setMenuResource() {
        return R.menu.home;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.home_height) {
            mFlowAdapter.setFlowStyle(FLOW_STYLE_HEIGHT);
            return true;
        }
        if (id == R.id.home_width) {
            mFlowAdapter.setFlowStyle(FLOW_STYLE_WIDTH);
            return true;
        }
        if (id == R.id.home_mix) {
            mFlowAdapter.setFlowStyle(FLOW_STYLE_MIX);
            return true;
        }
        return super.onOptionsItemSelected(item);
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
