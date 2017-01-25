package com.rja.moshizzle;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rjaylward on 11/26/16
 */

public class GifyApiResponse {

    @SerializedName("data")
    List<GifyInfo> gifyInfos;

    class GifyInfo {
        @SerializedName("id")
        String id;

        @SerializedName("images")
        GifyImages gifyImages;

        public CellInfo toCellInfo() {
            CellInfo info = new CellInfo(id);
            info.setMainUrl(gifyImages.fullHeight.url);
            info.setProfileImageUrl("https://www.google.com/fit/static/images/fit-logo-fallback-anim.png");
            info.setAspectRatio(gifyImages.fullHeight.width / gifyImages.fullHeight.height);
            return info;
        }
    }

    class GifyImages {
        @SerializedName("fixed_height")
        GifyImage fullHeight;

        @SerializedName("fixed_height_still")
        GifyImage fixedHeightStill;
    }

    class GifyImage {
        @SerializedName("url")
        String url;

        @SerializedName("height")
        int height;

        @SerializedName("width")
        int width;
    }

    public List<CellInfo> toCellInfo() {
        List<CellInfo> infoList = new ArrayList<>();

        for(GifyInfo gifyInfo : gifyInfos) {
            if(gifyInfo != null) {
                infoList.add(gifyInfo.toCellInfo());
            }
        }

        return infoList;
    }
}
