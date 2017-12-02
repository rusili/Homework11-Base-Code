package com.example.rusili.homework11.detailscreen.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.detailscreen.model.Pokemon;
import com.example.rusili.homework11.network.RetrofitFactory;

public class PokemonDetailActivity extends AppCompatActivity {
    private RetrofitFactory.PokemonNetworkListener pokemonNetworkListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detail);
        initialize();
//        RecyclerView pokedexRecyclerView = (RecyclerView) findViewById(R.id.pokedex_recyclerview);
    }

    private void initialize() {
        getPokemonDetails();
    }

    private void getPokemonDetails() {
        pokemonNetworkListener = new RetrofitFactory.PokemonNetworkListener() {
            @Override
            public void pokemonCallback(Pokemon pokemon) {
                //TODO: Display pokemon data
                //Hint: Learn how to use Glide to display an image.
                //do some more code

            }
        };
        RetrofitFactory.getInstance().setPokemonNetworkListener(pokemonNetworkListener);
        RetrofitFactory.getInstance().getPokemon("1");
    }
}
