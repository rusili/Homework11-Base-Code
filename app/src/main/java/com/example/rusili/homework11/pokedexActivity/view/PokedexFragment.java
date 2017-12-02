package com.example.rusili.homework11.pokedexActivity.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.network.RetrofitFactory;
import com.example.rusili.homework11.pokedexActivity.model.Pokedex;
import com.example.rusili.homework11.pokedexActivity.model.objects.PokemonEntries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by rusi.li on 11/22/17.
 */

public class PokedexFragment extends Fragment {
    private RetrofitFactory.PokedexNetworkListener pokedexNetworkListener;
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pokedex_fragment, container, false);
        getPokedexList();

        recyclerView = view.findViewById(R.id.recyclerView);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),3);

        recyclerView.setLayoutManager(gridLayoutManager);

        return view;

    }

    private void getPokedexList() {
        pokedexNetworkListener = new RetrofitFactory.PokedexNetworkListener() {
            @Override
            public void pokedexCallback(Pokedex pokedex) {

                List<PokemonEntries> pokemonEntries = new ArrayList<>();

                // TODO: show Pokemon
                // Each pokemon is in the Pokemon_Species object.
                PokemonEntries[] entries = pokedex.getPokemon_entries();

                for (int i = 0; i < entries.length; i++) {
                    pokemonEntries.add(pokedex.getPokemon_entries()[i]);

                }


                PokeDexAdapter adapter = new PokeDexAdapter(pokemonEntries);

                recyclerView.setAdapter(adapter);

            }
        };
        RetrofitFactory.getInstance().setPokedexListener(pokedexNetworkListener);
        RetrofitFactory.getInstance().getPokedex(2);
    }
}
