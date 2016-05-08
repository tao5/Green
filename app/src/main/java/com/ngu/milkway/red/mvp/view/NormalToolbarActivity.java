package com.ngu.milkway.red.mvp.view;

import com.ngu.milkway.red.R;

/**
 * Created by xt on 16/5/9.
 */
public abstract class NormalToolbarActivity extends NavigationActivity {

    @Override
    protected int setContentView() {
        return R.layout.activity_main_normal;
    }

    @Override
    protected void initActivity() {
        super.initActivity();
    }

    @Override
    protected int setHeadType() {
        return HEAD_NORMAL;
    }
}
