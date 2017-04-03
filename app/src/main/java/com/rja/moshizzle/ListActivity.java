package com.rja.moshizzle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.rja.moshizzle.pokemon.LocalPokemonProvider;
import com.rja.moshizzle.pokemon.Pokemon;
import com.rja.moshizzle.pokemon.PokemonAdapter;
import com.rja.moshizzle.pokemon.PokemonProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rjaylward on 4/2/17
 */

public class ListActivity extends AppCompatActivity {

    private static final String TAG = ListActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.al_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final PokemonAdapter adapter = new PokemonAdapter();
        recyclerView.setAdapter(adapter);

        List<Pokemon> pokemons = new ArrayList<>();

        Pokemon pokemon = new Pokemon();
        pokemon.setName("Charmander");
        pokemons.add(pokemon);
        pokemons.add(pokemon);
        pokemons.add(pokemon);
        pokemons.add(pokemon);
        pokemons.add(pokemon);
        pokemons.add(pokemon);

        adapter.setItems(pokemons);

        PokemonProvider pokemonProvider = new LocalPokemonProvider(this);
        pokemonProvider.getPokemon(new PokemonProvider.Callback() {

            @Override
            public void onSuccess(List<Pokemon> pokemon) {
                Log.d(TAG, "loading pokemon");
                adapter.setItems(pokemon);
            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.e(TAG, "Failed to get pokemon", throwable);
                Toast.makeText(ListActivity.this, "An Error Occurred", Toast.LENGTH_SHORT).show();
            }

        });

    }
}
