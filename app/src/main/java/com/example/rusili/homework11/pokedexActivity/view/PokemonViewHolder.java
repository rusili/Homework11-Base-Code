package com.example.rusili.homework11.pokedexActivity.view;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.detailscreen.view.PokemonDetailActivity;
import com.example.rusili.homework11.pokedexActivity.model.objects.PokemonEntries;

/**
 * Created by muridjonrahimov on 12/1/17.
 */

public class PokemonViewHolder extends RecyclerView.ViewHolder{

    public static final String POK_KEY = "pokemon_key";
    private TextView textView;
    private CardView cardView;


    public PokemonViewHolder(View itemView) {
        super(itemView);

        textView = itemView.findViewById(R.id.pokemon_name);
        cardView = itemView.findViewById(R.id.card_view);

    }
    public void onBind(final PokemonEntries pokemonEntries) {
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
