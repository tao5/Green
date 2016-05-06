package com.ngu.milkway.red.adapter.flowstyle;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.util.Log;

import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.image.QualityInfo;

/**
 * Created by xt on 16/5/6.
 */
public class FlowControllerListener extends BaseControllerListener<ImageInfo> {

    private SimpleDraweeView pic;
    private Uri uri;

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
