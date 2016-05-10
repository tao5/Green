package com.ngu.milkway.red.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.Map;

/**
 * Created by xt on 16/5/10.
 */
public abstract class BaseMapAdapter<K, V, VH extends RecyclerView.ViewHolder> extends BaseAdapter<Map<K, V>, VH> {

    public BaseMapAdapter(Map<K, V> data, Context context) {
        super(data, context);
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }
}
