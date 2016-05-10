package com.ngu.milkway.red.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by xt on 16/5/10.
 */
public abstract class BaseListAdapter<T, VH extends RecyclerView.ViewHolder> extends BaseAdapter<List<T>, VH> {

    public BaseListAdapter(List<T> data, Context context) {
        super(data, context);
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }
}
