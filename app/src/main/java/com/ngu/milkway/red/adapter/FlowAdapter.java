package com.ngu.milkway.red.adapter;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.ngu.milkway.red.R;

import java.util.List;

/**
 * Created by xt on 16/5/5.
 */
public class FlowAdapter extends RecyclerView.Adapter<FlowAdapter.FlowHolder> {

    private List<String> urls;

    public FlowAdapter(List<String> urls) {
        this.urls = urls;
    }

    @Override
    public FlowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_home_flow_item, parent, false);
        return new FlowHolder(view);
    }

    @Override
    public void onBindViewHolder(FlowHolder holder, int position) {
        Uri uri = Uri.parse(urls.get(position));
        AbstractDraweeController draweeController = Fresco.newDraweeControllerBuilder()
                .setControllerListener(new FlowControllerListener(holder.draweeView, uri))
                .setUri(uri)
                .build();
        holder.draweeView.setController(draweeController);
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

    class FlowControllerListener extends BaseControllerListener<ImageInfo> {

        SimpleDraweeView pic;
        Uri uri;

        public FlowControllerListener(SimpleDraweeView pic, Uri uri) {
            this.pic = pic;
            this.uri = uri;
        }

        @Override
        public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {
            super.onFinalImageSet(id, imageInfo, animatable);

            if (imageInfo == null) {
                return;
            }

            QualityInfo picInfo = imageInfo.getQualityInfo();
            int quality = picInfo.getQuality();
            int width = imageInfo.getWidth();
            int height = imageInfo.getHeight();
            Log.d("dawn", "width = " + width + ", height = " + height + ", quality = " + quality);
            if (width >= height) {
                pic.setAspectRatio(1.333f);
            } else {
                pic.setAspectRatio(0.75f);
            }
            //setHierarchyForDraweeView(pic, 200);
            pic.setImageURI(uri);

            int originWidth = pic.getMeasuredWidth();
            int originHeight = pic.getMeasuredHeight();
            Log.d("dawn", "o width = " + originWidth + ", height = " + originHeight);
        }
    }

}
