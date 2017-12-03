package com.example.rusili.homework11.pokedexActivity.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.rusili.homework11.R;
import com.example.rusili.homework11.detailscreen.view.PokemonDetailActivity;
import com.example.rusili.homework11.pokedexActivity.model.objects.PokemonEntries;

/**
 * Created by joannesong on 12/1/17.
 */

class PokemonViewHolder extends RecyclerView.ViewHolder{

    private TextView pokemonName;
    private Context context;
    private ImageView imageView;
    private CardView cardView;

    public PokemonViewHolder(View itemView) {
        super(itemView);

        pokemonName = itemView.findViewById(R.id.name_view);
        imageView = itemView.findViewById(R.id.itemv_image);
        cardView = itemView.findViewById(R.id.card_view);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PokemonDetailActivity.class);
                intent.putExtra("pokemonName", pokemonName.getText().toString());
                view.getContext().startActivity(intent);
            }
        });

    }

    public void bind(PokemonEntries pokemonEntries){
        pokemonName.setText(pokemonEntries.getPokemon_species().getName());
        context = itemView.getContext();

        String urlPt1 ="https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/";
        String urlPt2 =".png";
        String url = urlPt1+pokemonEntries.getEntry_number()+urlPt2;

        Glide.with(context)
                .load(url)
                .override(125,125)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }
}
