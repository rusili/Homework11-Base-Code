package com.example.rusili.homework11;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rusili.homework11.detailscreen.model.Pokemon;

import java.util.List;

/**
 * Created by c4q on 11/29/17.
 */

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokeViewHolder> {
    private List<Pokemon> pokemonList;

    @Override
    public PokeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.pokemon_row, parent, false);

        return new PokeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PokeViewHolder holder, int position) {
        Pokemon pokemon = pokemonList.get(position);
        holder.name.setText(pokemon.getName());
        holder.type.setText(pokemon.pokeTypesToString());


    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }


    public class PokeViewHolder extends RecyclerView.ViewHolder {
        public TextView name, type;

        public PokeViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_name);
            type = (TextView) itemView.findViewById(R.id.tv_type);
        }


    }
    public PokemonAdapter(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }
}
