package com.ngu.milkway.red.mvp.view.setting.impl;

import com.ngu.milkway.red.R;
import com.ngu.milkway.red.mvp.presenter.BasePresenter;
import com.ngu.milkway.red.mvp.view.BaseFragment;
import com.ngu.milkway.red.mvp.view.setting.SettingView;
import com.ngu.milkway.red.utils.AnimationUtils;

import static com.ngu.milkway.red.mvp.view.NavigationActivity.HEAD_NORMAL;

/**
 * Created by xt on 16/4/29.
 */
public class SettingFragment extends BaseFragment implements SettingView {

    @Override
    protected int setResource() {
        return R.layout.fr_setting;
    }

    @Override
    protected void initFragment() {
        AnimationUtils.loadExplosionAnim(getActivity(), view.findViewById(R.id.my_image));
        setHeadType(HEAD_NORMAL);
    }

    @Override
    public void setPresenter(BasePresenter presenter) {

    }

}
