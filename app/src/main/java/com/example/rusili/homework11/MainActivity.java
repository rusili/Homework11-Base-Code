package com.example.rusili.homework11;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.rusili.homework11.controller.PokedexAdapter;
import com.example.rusili.homework11.network.RetrofitFactory;
import com.example.rusili.homework11.pokedexActivity.model.Pokedex;
import com.example.rusili.homework11.pokedexActivity.model.objects.PokemonEntries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RetrofitFactory.PokedexNetworkListener pokedexNetworkListener;
    private RecyclerView pokedexRecycler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pokedexRecycler = (RecyclerView) findViewById(R.id.pokedex_recyclerview);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        getPokedexList();
        pokedexRecycler.setLayoutManager(gridLayoutManager);
    }

    private void getPokedexList () {
        pokedexNetworkListener = new RetrofitFactory.PokedexNetworkListener() {
            @Override
            public void pokedexCallback (Pokedex pokedex) {
                // TODO: show Pokemon
                // Each pokemon is in the Pokemon_Species object.

                List<PokemonEntries> pokemonEntriesList = new ArrayList<>();
                Collections.addAll(pokemonEntriesList, pokedex.getPokemon_entries());
                pokedexRecycler.setAdapter(new PokedexAdapter(pokemonEntriesList));

//                List<String> pokemonEntries = new ArrayList<>();
//                for (int i = 0; i <= 150; i++) {
//                    pokemonEntries.add(pokedex.getPokemon_entries()[i].getPokemon_species().getName());
//                }
//                PokedexAdapter pokedexAdapter = new PokedexAdapter(pokemonEntries)

            }
        };
        RetrofitFactory.getInstance().setPokedexListener(pokedexNetworkListener);
        RetrofitFactory.getInstance().getPokedex(2);
    }
}


