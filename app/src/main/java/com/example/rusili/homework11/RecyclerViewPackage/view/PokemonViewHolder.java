package com.example.rusili.homework11.RecyclerViewPackage.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.RecyclerViewPackage.model.Pokemon;
import com.example.rusili.homework11.pokedexActivity.model.objects.PokemonEntries;

/**
 * Created by Shant on 11/29/2017.
 */

public class PokemonViewHolder extends RecyclerView.ViewHolder{

    TextView pokemonName;

    public PokemonViewHolder(View itemView) {
        super(itemView);
        pokemonName = itemView.findViewById(R.id.pokemon_name_text_view);
    }

    public void onBind(PokemonEntries pokemon){
        pokemonName.setText(pokemon.getPokemon_species().getName());
    }
}
