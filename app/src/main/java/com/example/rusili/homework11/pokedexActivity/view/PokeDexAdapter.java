package com.example.rusili.homework11.pokedexActivity.view;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.detailscreen.view.PokemonDetailActivity;
import com.example.rusili.homework11.pokedexActivity.model.Pokedex;
import com.example.rusili.homework11.pokedexActivity.model.objects.PokemonEntries;

import java.util.List;

/**
 * Created by TatianaM on 11/30/17.
 */

public class PokeDexAdapter extends RecyclerView.Adapter<PokedexViewHolder> {

    private List<PokemonEntries> pokedexList;



    public PokeDexAdapter(List<PokemonEntries> pokemonEntries) {
        this.pokedexList = pokemonEntries;
    }

    @Override
    public PokedexViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent,false);


        return new PokedexViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PokedexViewHolder holder, int position) {
        PokemonEntries pokedex = pokedexList.get(position);
        holder.onBind(pokedex);

    }

    @Override
    public int getItemCount() {
        return pokedexList.size();
    }
}

