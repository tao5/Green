package com.ngu.milkway.red.mvp.view.home;

import com.ngu.milkway.red.mvp.presenter.home.IHomePresenter;
import com.ngu.milkway.red.mvp.view.BaseView;

/**
 * Created by xt on 16/4/29.
 */
public interface IHomeView extends BaseView<IHomePresenter> {



    void closeDraw();

    void openDraw();

    void showFab();

    void closeFab();
}
