package com.rja.moshizzle.pokemon;

import java.util.List;

/**
 * Created by rjaylward on 4/2/17
 */

public interface PokemonProvider {

    void getPokemon(Callback callback);

    interface Callback {
        void onSuccess(List<Pokemon> pokemons);
        void onFailure(Throwable throwable);
    }
}
