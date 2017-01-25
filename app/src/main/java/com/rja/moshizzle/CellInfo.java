package com.rja.moshizzle;

/**
 * Created by rjaylward on 11/26/16
 */

public class CellInfo {

    private String profileImageUrl;
    private String name;
    private String mainUrl;

    private float aspectRatio;

    private boolean isLiked;

    public CellInfo(String name) {
        this.name = name;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMainUrl() {
        return mainUrl;
    }

    public void setMainUrl(String mainUrl) {
        this.mainUrl = mainUrl;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }

    @Override
    public String toString() {
        return "CellInfo{" +
                "profileImageUrl='" + profileImageUrl + '\'' +
                ", name='" + name + '\'' +
                ", mainUrl='" + mainUrl + '\'' +
                ", isLiked=" + isLiked +
                '}';
    }

    public float getAspectRatio() {
        return aspectRatio;
    }

    public void setAspectRatio(float aspectRatio) {
        this.aspectRatio = aspectRatio;
    }
}
