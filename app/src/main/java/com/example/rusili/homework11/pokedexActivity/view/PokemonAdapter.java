package com.example.rusili.homework11.pokedexActivity.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.pokedexActivity.model.objects.PokemonEntries;

import java.util.List;

/**
 * Created by joannesong on 12/1/17.
 */

public class PokemonAdapter extends RecyclerView.Adapter<PokemonViewHolder> {

    List<PokemonEntries> pokemonEntriesList;

    public PokemonAdapter(List<PokemonEntries> pokemonEntries) {
        this.pokemonEntriesList = pokemonEntries;
    }

    @Override
    public PokemonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childview = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_itemview, parent, false);

        return new PokemonViewHolder(childview);
    }

    @Override
    public void onBindViewHolder(PokemonViewHolder holder, int position) {
        holder.bind(pokemonEntriesList.get(position));

    }

    @Override
    public int getItemCount() {
        return pokemonEntriesList.size();
    }
}
