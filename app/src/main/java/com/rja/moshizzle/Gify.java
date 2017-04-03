package com.rja.moshizzle;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by rjaylward on 4/2/17
 */

public class Gify {

    private Api mApi;

    public Api getApi() {
        if(mApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://api.giphy.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mApi = retrofit.create(Api.class);
        }

        return mApi;
    }

    public interface Api {

        @GET("v1/gifs/trending?api_key=dc6zaTOxFJmzC&limit=50")
        Call<Response> getRandomGifs();

    }

    public class Response {

        @SerializedName("data")
        List<GifyData> mGifyDatas;

        public List<GifyData> getData() {
            return mGifyDatas;
        }

        class GifyData {

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

            public String getId() {
                return id;
            }

            public GifyImages getGifyImages() {
                return gifyImages;
            }

        }

        class GifyImages {

            @SerializedName("fixed_height")
            GifyImage fullHeight;

            @SerializedName("fixed_height_still")
            GifyImage fixedHeightStill;


            public GifyImage getFullHeight() {
                return fullHeight;
            }

            public GifyImage getFixedHeightStill() {
                return fixedHeightStill;
            }
        }

        class GifyImage {

            @SerializedName("url")
            String url;

            @SerializedName("height")
            int height;

            @SerializedName("width")
            int width;

            public String getUrl() {
                return url;
            }

            public int getHeight() {
                return height;
            }

            public int getWidth() {
                return width;
            }
        }
    }
}
