package com.ngu.milkway.red.adapter.flowstyle;

import android.net.Uri;

import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by xt on 16/5/6.
 */
public class FlowHeightStyle extends FlowStyle {

    public FlowHeightStyle(SimpleDraweeView draweeView, Uri uri) {
        super(draweeView, uri);
    }

    @Override
    public void setFlowStyle() {
        draweeView.setAspectRatio(0.75f);
        draweeView.setImageURI(uri);
    }
}
