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

    private List<Gify.Response.GifyData> mItems = new ArrayList<>();
    private Context mContext;

    public void setItem(Context context, List<Gify.Response.GifyData> list) {
        this.mContext = context;
        this.mItems = list;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ImageViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.instagram_cell, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ImageViewHolder) {
            ((ImageViewHolder) holder).loadData(toCellInfo(mItems.get(position)), mContext);
        }
    }

    private CellInfo toCellInfo(Gify.Response.GifyData gifyData) {
        CellInfo info = new CellInfo(gifyData.getId());
        info.setMainUrl(gifyData.getGifyImages().getFullHeight().getUrl());
        info.setProfileImageUrl("https://www.google.com/fit/static/images/fit-logo-fallback-anim.png");
        info.setAspectRatio(gifyData.getGifyImages().getFullHeight().getAspectRatio());

        return info;
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

}
