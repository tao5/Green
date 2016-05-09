package com.ngu.milkway.red.mvp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.ngu.milkway.red.R;

/**
 * Created by xt on 16/5/9.
 */
public abstract class CollapsingToolbarActivity extends NavigationActivity {

    private View mCollapseHead;
    private View mNormalHead;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCollapseHead = findViewById(R.id.drawer_content_head_collapsing_);
        mNormalHead = findViewById(R.id.drawer_content_head_normal_);
    }

    @Override
    public void setHeadType(int type) {
        setToolbar(type);
        if (type == HEAD_COLLAPSING) {
            mCollapseHead.setVisibility(View.VISIBLE);
            mNormalHead.setVisibility(View.GONE);
        } else if (type == HEAD_NORMAL) {
            mCollapseHead.setVisibility(View.GONE);
            mNormalHead.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected int setContentView() {
        return R.layout.activity_main_collapsing;
    }

    @Override
    protected int setHeadType() {
        return HEAD_COLLAPSING;
    }
}
