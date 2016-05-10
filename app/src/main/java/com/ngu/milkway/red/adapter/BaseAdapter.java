package com.ngu.milkway.red.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

/**
 * Created by xt on 16/5/10.
 */
public abstract class BaseAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH>{

    protected T data;
    protected Context context;

    public BaseAdapter(T data, Context context) {
        this.data = data;
        this.context = context;
    }

    public void update(T data) {
        this.data = data;
        notifyDataSetChanged();
    }

}
