package com.ngu.milkway.red.adapter;

import android.net.Uri;

import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by xt on 16/5/6.
 */
public abstract class FlowStyle {

    protected SimpleDraweeView draweeView;
    protected Uri uri;

    public FlowStyle(SimpleDraweeView draweeView, Uri uri) {
        this.draweeView = draweeView;
        this.uri = uri;
    }

    public abstract void setFlowStyle();
}
