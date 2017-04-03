package com.rja.moshizzle.pokemon;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by rjaylward on 4/2/17
 */

public class LocalPokemonProvider implements PokemonProvider {

    private Gson mGson;
    private Context mContext;

    public LocalPokemonProvider(Context context) {
        mContext = context;
        mGson = new Gson();
    }

    public List<Pokemon> readPokemon(Context context) throws Exception {
        InputStream is = context.getAssets().open("pokemon.json");

        int size = is.available();

        byte[] buffer = new byte[size];

        is.read(buffer);
        is.close();

        String json = new String(buffer, "UTF-8");
        Type listType = new TypeToken<List<Pokemon>>(){}.getType();
        return mGson.fromJson(json, listType);
    }

    @Override
    public void getPokemon(Callback callback) {
        try {
            callback.onSuccess(readPokemon(mContext));
        }
        catch(Exception e) {
            callback.onFailure(e);
        }
    }

}
