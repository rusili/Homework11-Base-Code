package com.example.rusili.homework11.RecyclerViewPackage.view;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.rusili.homework11.R;
import com.example.rusili.homework11.RecyclerViewPackage.model.Pokemon;
import com.example.rusili.homework11.detailscreen.view.PokemonDetailActivity;
import com.example.rusili.homework11.main.MainActivity;
import com.example.rusili.homework11.network.RetrofitFactory;
import com.example.rusili.homework11.pokedexActivity.model.objects.PokemonEntries;

import java.util.Arrays;

/**
 * Created by Shant on 11/29/2017.
 */

public class PokemonViewHolder extends RecyclerView.ViewHolder {

    ImageView sprite;
    TextView pokemonName;
    RetrofitFactory.PokemonNetworkListener pokemonNetworkListener;
    String pokemon;
    String picUrl;
    String name;

    public PokemonViewHolder(View itemView) {
        super(itemView);
        pokemonName = itemView.findViewById(R.id.pokemon_name_text_view);
        sprite = itemView.findViewById(R.id.sprite);
    }

    public void onBind(final PokemonEntries pokemon) {
        pokemonName.setText(pokemon.getPokemon_species().getName());

        StringBuilder imgUrl = new StringBuilder();
        imgUrl.append("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/");
        imgUrl.append((String) Integer.toString(pokemon.getEntry_number());
        imgUrl.append(".png");



        Glide.with(itemView.getContext())
                .load(imgUrl.toString())
                .into(sprite);




        itemView.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent intent = new Intent(itemView.getContext(), PokemonDetailActivity.class);
                                            name = pokemon.getPokemon_species().getName();
                                            intent.putExtra("pokemon", name);
                                            itemView.getContext().startActivity(intent);
                                        }
                                    }
        );







    }




}
