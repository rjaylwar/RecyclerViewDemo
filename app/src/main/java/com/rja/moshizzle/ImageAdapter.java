package com.rja.moshizzle;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rjaylward on 11/26/16
 */

public class ImageAdapter extends RecyclerView.Adapter {

    private List<GifyApiResponse.GifyInfo> mItems = new ArrayList<>();
    private Context mContext;

    public void setItem(Context context, List<GifyApiResponse.GifyInfo> list) {
        this.mContext = context;
        this.mItems = list;
        notifyItemRangeInserted(0, list.size());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ImageViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.instagram_cell, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ImageViewHolder) {
            ((ImageViewHolder) holder).loadData(mItems.get(position).toCellInfo(), mContext);
        }
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

}
