package com.ngu.milkway.red.adapter.flowstyle;

import android.net.Uri;

import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by xt on 16/5/6.
 */
public class FlowStyleContext {

    public final static int FLOW_STYLE_HEIGHT = 0;
    public final static int FLOW_STYLE_WIDTH = 1;
    public final static int FLOW_STYLE_MIX = 2;
    private FlowStyle flowStyle;

    public FlowStyleContext(SimpleDraweeView draweeView, Uri uri, int style) {
        if (FLOW_STYLE_HEIGHT == style) {
            flowStyle = new FlowHeightStyle(draweeView, uri);
        } else if (FLOW_STYLE_WIDTH == style) {
            flowStyle = new FlowWidthStyle(draweeView, uri);
        } else if (FLOW_STYLE_MIX == style) {
            flowStyle = new FlowMixStyle(draweeView, uri);
        } else {
            flowStyle = new FlowHeightStyle(draweeView, uri);
        }
    }

    public void setFlowStyle() {
        flowStyle.setFlowStyle();
    }
}
