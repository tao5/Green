package com.ngu.milkway.red.mvp.view.home;

import com.ngu.milkway.red.mvp.presenter.home.HomePresenter;
import com.ngu.milkway.red.mvp.view.BaseView;

import java.util.List;

/**
 * Created by xt on 16/4/29.
 */
public interface HomeView extends BaseView<HomePresenter> {

    void closeDraw();

    void openDraw();

    void showFab();

    void closeFab();

    void showSnackbar(String info);

    void showImageFlow(List<String> urls);
}
