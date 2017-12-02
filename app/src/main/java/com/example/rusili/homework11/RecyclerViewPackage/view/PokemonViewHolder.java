package com.example.rusili.homework11.RecyclerViewPackage.view;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.rusili.homework11.R;
import com.example.rusili.homework11.RecyclerViewPackage.model.Pokemon;
import com.example.rusili.homework11.detailscreen.view.PokemonDetailActivity;
import com.example.rusili.homework11.pokedexActivity.model.objects.PokemonEntries;

/**
 * Created by Shant on 11/29/2017.
 */

public class PokemonViewHolder extends RecyclerView.ViewHolder{

    ImageView sprite;
    TextView pokemonName;

    public PokemonViewHolder(View itemView) {
        super(itemView);
        pokemonName = itemView.findViewById(R.id.pokemon_name_text_view);
        sprite = itemView.findViewById(R.id.sprite);
    }

    public void onBind(PokemonEntries pokemon){
        final PokemonEntries pokemon1 = pokemon;
        Log.d("pokemon",pokemon.getPokemon_species().getName());
        pokemonName.setText(pokemon.getPokemon_species().getName());
        Glide.with(itemView.getContext())
                .load(pokemon.getPokemon_species().getUrl())
                .into(sprite);

        itemView.setOnClickListener(new View.OnClickListener(){
            @Override
           public void onClick(View view){
                Intent intent = new Intent(itemView.getContext(), PokemonDetailActivity.class);
                String name = pokemon1.getPokemon_species().getName();
                intent.putExtra("pokemon",name);
                itemView.getContext().startActivity(intent);
            }
                                    }
        );


    }
}
