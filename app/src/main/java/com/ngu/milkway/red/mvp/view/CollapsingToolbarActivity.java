package com.ngu.milkway.red.mvp.view;

import com.ngu.milkway.red.R;

/**
 * Created by xt on 16/5/9.
 */
public abstract class CollapsingToolbarActivity extends NavigationActivity {

    @Override
    protected int setContentView() {
        return R.layout.activity_main_collapsing;
    }

    @Override
    protected int setHeadType() {
        return HEAD_COLLAPSING;
    }
}
