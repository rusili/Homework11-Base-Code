package com.example.rusili.homework11.pokedexActivity.view;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.rusili.homework11.R;
import com.example.rusili.homework11.detailscreen.model.objects.Sprites;
import com.example.rusili.homework11.detailscreen.model.objects.Stats;
import com.example.rusili.homework11.detailscreen.view.PokemonDetailActivity;
import com.example.rusili.homework11.pokedexActivity.model.objects.PokemonEntries;
import com.squareup.picasso.Picasso;

/**
 * Created by muridjonrahimov on 12/1/17.
 */

public class PokemonViewHolder extends RecyclerView.ViewHolder{

    public static final String POK_KEY = "pokemon_key";
    private TextView textView;
    private CardView cardView;
    private ImageView cardImage;

    public PokemonViewHolder(View itemView) {
        super(itemView);

        textView = itemView.findViewById(R.id.pokemon_name);
        cardView = itemView.findViewById(R.id.card_view);
        cardImage = itemView.findViewById(R.id.card_image);

    }
    public void onBind(final PokemonEntries pokemonEntries) {

        StringBuilder xyz = new StringBuilder("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/");
        xyz.append(pokemonEntries.getEntry_number()).append(".png");
        Glide.with(cardImage.getContext())
                .load(xyz.toString())
                .into(cardImage);
        textView.setText(pokemonEntries.getPokemon_species().getName());
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
                   public void onClick(View v) {

                Intent intent = new Intent(cardView.getContext(), PokemonDetailActivity.class);
                intent.putExtra(POK_KEY, pokemonEntries.getPokemon_species().getName());
                cardView.getContext().startActivity(intent);
            }
        });
    }
}
