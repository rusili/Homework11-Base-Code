package com.example.rusili.homework11.RecycleView;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.pokedexActivity.model.objects.PokemonEntries;


/**
 * Created by c4q on 12/2/17.
 */

class PokViewHolder extends RecyclerView.ViewHolder {
    public PokViewHolder(View itemView) {
        super(itemView);
    }

    public void bind(PokemonEntries pokemonEntries) {
        TextView pokName= (TextView)itemView.findViewById(R.id.pok_name);
        pokName.setText(pokemonEntries.getPokemon_species().getName());


    }
}
