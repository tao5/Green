package com.ngu.milkway.red.mvp.view;

import com.ngu.milkway.red.mvp.presenter.BasePresenter;

/**
 * Created by xt on 16/4/29.
 */
public interface BaseView<T extends BasePresenter> {
    void setPresenter(T presenter);
}
