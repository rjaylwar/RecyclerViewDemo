package com.rja.moshizzle;

import android.content.Context;
import android.support.percent.PercentFrameLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import static com.bumptech.glide.load.engine.DiskCacheStrategy.SOURCE;

/**
 * Created by rjaylward on 11/26/16
 */

public class ImageViewHolder extends RecyclerView.ViewHolder {

    private ImageView profileImage;
    private TextView nameView;
    private ImageView mainImage;
    private View profileLayout;

    public ImageViewHolder(View itemView) {
        super(itemView);

        profileLayout = itemView.findViewById(R.id.profile_layout);
        profileImage = (ImageView) itemView.findViewById(R.id.profile_image);
        nameView = (TextView) itemView.findViewById(R.id.profile_name);
        mainImage = (ImageView) itemView.findViewById(R.id.main_image);
    }

    public void loadData(final CellInfo data, final Context context) {
        Log.d("ImageViewHolder", data.toString());

        PercentFrameLayout.LayoutParams params = (PercentFrameLayout.LayoutParams) mainImage.getLayoutParams();
        params.getPercentLayoutInfo().aspectRatio = data.getAspectRatio();
        params.getPercentLayoutInfo().widthPercent = 1f;

        mainImage.setLayoutParams(params);

        Glide.with(context).load(data.getMainUrl())
                .diskCacheStrategy(SOURCE)
                .placeholder(android.R.drawable.screen_background_dark_transparent)
                .into(mainImage);

        Glide.with(context).load(data.getProfileImageUrl())
                .centerCrop()
                .into(profileImage);

        nameView.setText(data.getName());
    }
}
