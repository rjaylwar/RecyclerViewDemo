package com.rja.moshizzle.pokemon;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import java.io.InputStream;
import java.util.List;

/**
 * Created by rjaylward on 4/2/17
 */

public class LocalPokemonProvider implements PokemonProvider {

    private static final String TAG = LocalPokemonProvider.class.getSimpleName();

    private Gson mGson;
    private Context mContext;

    public LocalPokemonProvider(Context context) {
        mContext = context;
        mGson = new Gson();
    }

    public List<Pokemon> readPokemon(Context context) throws Exception {
        Log.v(TAG, "Getting Pokemon!");
        InputStream is = context.getAssets().open("pokemon.json");

        int size = is.available();

        byte[] buffer = new byte[size];

        is.read(buffer);
        is.close();

        String json = new String(buffer, "UTF-8");
        Log.v(TAG, "Got Pokemon! " + json);
        return mGson.fromJson(json, PokemonResponse.class).getResults();
    }

    @Override
    public void getPokemon(Callback callback) {
        try {
            callback.onSuccess(readPokemon(mContext));
        }
        catch(Exception e) {
            e.printStackTrace();
            callback.onFailure(e);
        }
    }

}
