package com.rja.moshizzle;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by rjaylward on 11/26/16
 */

public interface GifyApi {

    @GET("v1/gifs/trending?api_key=dc6zaTOxFJmzC&limit=50")
    public Call<GifyApiResponse> getRandomGifs();

}
