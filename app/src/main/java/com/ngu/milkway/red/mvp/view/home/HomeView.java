package com.ngu.milkway.red.mvp.view.home;

import com.ngu.milkway.red.mvp.presenter.home.HomePresenter;
import com.ngu.milkway.red.mvp.view.BaseView;
import com.ngu.milkway.red.mvp.view.ISnackbar;

import java.util.List;

/**
 * Created by xt on 16/4/29.
 */
public interface HomeView extends BaseView<HomePresenter>, ISnackbar {

    void closeDraw();

    void openDraw();

    void showFab();

    void closeFab();

    void showImageFlow(List<String> urls);
}
