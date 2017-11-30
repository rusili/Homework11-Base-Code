package com.example.rusili.homework11.controller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.rusili.homework11.R;
import com.example.rusili.homework11.pokedexActivity.model.Pokedex;
import com.example.rusili.homework11.pokedexActivity.model.objects.PokemonEntries;

import java.util.List;

/**
 * Created by oleg on 11/29/17.
 */

public class PokedexAdapter extends RecyclerView.Adapter<PokedexAdapter.PokedexViewHolder> {


    private List<PokemonEntries> pokemonEntriesList;
    private Context context;

    public PokedexAdapter(List<PokemonEntries> pokemonEntriesList) {
        this.pokemonEntriesList = pokemonEntriesList;
    }

    @Override
    public PokedexViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokedex_itemview, parent, false);
        return new PokedexViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PokedexViewHolder holder, int position) {
        PokemonEntries pokemonEntries = pokemonEntriesList.get(position);
        holder.pokedexText.setText(pokemonEntries.getPokemon_species().getName());


    }

    @Override
    public int getItemCount() {
        return pokemonEntriesList.size();
    }

    public class PokedexViewHolder extends RecyclerView.ViewHolder {

        private ImageView pokedexView;
        private TextView pokedexText;

        public PokedexViewHolder(View itemView) {
            super(itemView);

            pokedexView = (ImageView) itemView.findViewById(R.id.pokedex_imageview);
            pokedexText = (TextView) itemView.findViewById(R.id.pokedex_textview);
        }
    }
}
