package com.example.rusili.homework11.pokedexActivity.view;

import android.content.Context;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.rusili.homework11.R;
import com.example.rusili.homework11.pokedexActivity.model.Pokedex;
import com.example.rusili.homework11.pokedexActivity.model.objects.PokemonEntries;

import org.w3c.dom.Text;

/**
 * Created by TatianaM on 11/30/17.
 */

public class PokedexViewHolder extends ViewHolder {

    TextView name;
    ImageView pokemonPic;
    Context context;


    public PokedexViewHolder(View itemView) {
        super(itemView);
        name = (TextView) itemView.findViewById(R.id.pokedex_name);

    }


    public void onBind(PokemonEntries pokedex) {

        pokemonPic = itemView.findViewById(R.id.pokemon_images);
        context = itemView.getContext();

        name.setText(pokedex.getPokemon_species().getName());
        String url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + pokedex.getEntry_number() + ".png";


        Glide.with(context)
                .load(url)
                .into(pokemonPic);


    }


}
