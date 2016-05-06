package com.ngu.milkway.red.adapter;

import android.net.Uri;

import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by xt on 16/5/6.
 */
public class FlowWidthStyle extends FlowStyle {

    public FlowWidthStyle(SimpleDraweeView draweeView, Uri uri) {
        super(draweeView, uri);
    }

    @Override
    public void setFlowStyle() {
        draweeView.setAspectRatio(1.333f);
        draweeView.setImageURI(uri);
    }
}
