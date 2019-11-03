package com.example.rusili.homework11.pokedexActivity.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.pokedexActivity.model.objects.PokemonEntries;

/**
 * Created by muridjonrahimov on 12/1/17.
 */

public class PokemonAdapter extends RecyclerView.Adapter<PokemonViewHolder> {
    private PokemonEntries[] pokemonEntries;

    public PokemonAdapter() {}

    public void setData(PokemonEntries[] pokemonEntries) {
        this.pokemonEntries = pokemonEntries;
        notifyDataSetChanged();
    }

    @Override
    public PokemonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_itemview, parent, false);
        return new PokemonViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(PokemonViewHolder holder, int position) {
        if (pokemonEntries != null) {
            PokemonEntries pokemonEntries1 = pokemonEntries[position];
            holder.onBind(pokemonEntries1);
        }

    }

    @Override
    public int getItemCount() {
        if (pokemonEntries == null) {
            return 0;
        }
        return pokemonEntries.length;
    }
}
