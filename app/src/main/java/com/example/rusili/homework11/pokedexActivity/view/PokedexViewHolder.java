package com.example.rusili.homework11.pokedexActivity.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.rusili.homework11.R;
import com.example.rusili.homework11.detailscreen.model.Pokemon;
import com.example.rusili.homework11.detailscreen.model.objects.Type;
import com.example.rusili.homework11.detailscreen.view.PokemonDetailActivity;
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
    CardView cardView;
    Pokemon pokemon;


    public PokedexViewHolder(View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.pokedex_name);
        cardView = itemView.findViewById(R.id.cardview);



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
