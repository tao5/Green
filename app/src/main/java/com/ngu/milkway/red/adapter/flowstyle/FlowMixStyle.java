package com.ngu.milkway.red.adapter.flowstyle;

import android.net.Uri;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by xt on 16/5/6.
 */
public class FlowMixStyle extends FlowStyle {

    public FlowMixStyle(SimpleDraweeView draweeView, Uri uri) {
        super(draweeView, uri);
    }

    @Override
    public void setFlowStyle() {
        AbstractDraweeController draweeController = Fresco.newDraweeControllerBuilder()
                .setControllerListener(new FlowControllerListener(draweeView, uri))
                .setUri(uri)
                .build();
        draweeView.setController(draweeController);
    }
}
