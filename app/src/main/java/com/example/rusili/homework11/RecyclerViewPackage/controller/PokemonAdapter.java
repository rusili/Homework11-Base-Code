package com.example.rusili.homework11.RecyclerViewPackage.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.RecyclerViewPackage.model.Pokemon;
import com.example.rusili.homework11.RecyclerViewPackage.view.PokemonViewHolder;
import com.example.rusili.homework11.pokedexActivity.model.objects.PokemonEntries;

import java.util.List;

/**
 * Created by Shant on 11/29/2017.
 */

public class PokemonAdapter extends RecyclerView.Adapter<PokemonViewHolder> {

    List<PokemonEntries> myPokemonList;

    public PokemonAdapter(List<PokemonEntries> myPokemonList) {
        this.myPokemonList = myPokemonList;
    }

    @Override
    public PokemonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View holder = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);

        return new PokemonViewHolder(holder);
    }

    @Override
    public void onBindViewHolder(PokemonViewHolder holder, int position) {
        PokemonEntries poke = myPokemonList.get(position);
        holder.onBind(poke);

    }

    @Override
    public int getItemCount() {
        return myPokemonList.size();
    }
}
