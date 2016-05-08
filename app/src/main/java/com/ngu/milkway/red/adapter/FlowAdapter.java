package com.ngu.milkway.red.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.ngu.milkway.red.R;
import com.ngu.milkway.red.adapter.flowstyle.FlowStyleContext;
import com.ngu.milkway.red.adapter.flowstyle.FlowStyleFactory;

import java.util.List;

/**
 * Created by xt on 16/5/5.
 */
public class FlowAdapter extends RecyclerView.Adapter<FlowAdapter.FlowHolder> {

    private List<String> urls;

    private int flowStyle;

    public FlowAdapter(List<String> urls) {
        this.urls = urls;
        flowStyle = FlowStyleFactory.FLOW_STYLE_HEIGHT;
    }

    @Override
    public FlowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_home_flow_item, parent, false);
        //AnimationUtils.loadExplosionAnim((Activity) parent.getContext(), parent);
        return new FlowHolder(view);
    }

    @Override
    public void onBindViewHolder(FlowHolder holder, int position) {
        Uri uri = Uri.parse(urls.get(position));
        // FlowStyleFactory.createFlowStyle(holder.draweeView, uri, flowStyle).setFlowStyle();
        new FlowStyleContext(holder.draweeView, uri, flowStyle).setFlowStyle();
    }

    public void setFlowStyle(int flowStyle) {
        this.flowStyle = flowStyle;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return urls != null ? urls.size() : 0;
    }

    class FlowHolder extends RecyclerView.ViewHolder {

        private SimpleDraweeView draweeView;

        public FlowHolder(View itemView) {
            super(itemView);
            draweeView = (SimpleDraweeView) itemView.findViewById(R.id.sv_home_flow_image);
        }
    }

}
