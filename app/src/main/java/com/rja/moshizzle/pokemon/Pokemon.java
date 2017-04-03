package com.rja.moshizzle.pokemon;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rjaylward on 4/2/17
 */

public class Pokemon {

    @SerializedName("name")
    private String mName;
    @SerializedName("url")
    private String mUrl;

    public String getName() {
        return mName;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setName(String name) {
        mName = name;
    }

    public void setUrl(String url) {
        mUrl = url;
    }
}
