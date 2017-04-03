package com.rja.moshizzle.pokemon;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rjaylward on 4/2/17
 */

public class PokemonResponse {

    @SerializedName("results")
    private List<Pokemon> mPokemonList;

    public List<Pokemon> getResults() {
        return mPokemonList;
    }

}